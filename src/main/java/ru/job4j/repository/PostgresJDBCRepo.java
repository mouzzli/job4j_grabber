package ru.job4j.repository;

import ru.job4j.model.Vacancy;

import java.sql.*;

import static ru.job4j.util.Util.getProperty;

public class PostgresJDBCRepo implements VacancyRepo {
    private Connection connection;

    public PostgresJDBCRepo() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    getProperty("url"),
                    getProperty("username"),
                    getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Vacancy vacancy) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO vacancies(company, title, link, description, datetime) values(?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, vacancy.getCompany());
            preparedStatement.setString(2, vacancy.getTitle());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setString(4, vacancy.getDescription());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(vacancy.getDateTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

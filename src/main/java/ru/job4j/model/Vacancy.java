package ru.job4j.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vacancy {
    public Vacancy(String company, String title, String link, String description, LocalDateTime dateTime) {
        this.company = company;
        this.title = title;
        this.link = link;
        this.description = description;
        this.dateTime = dateTime;
    }

    private int id;
    private String company;
    private String title;
    private String link;
    private String description;

    public String getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    private LocalDateTime dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return getId() == vacancy.getId() && getCompany().equals(vacancy.getCompany()) && getTitle().equals(vacancy.getTitle()) && getLink().equals(vacancy.getLink()) && getDescription().equals(vacancy.getDescription()) && getDateTime().equals(vacancy.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompany(), getTitle(), getLink(), getDescription(), getDateTime());
    }
}

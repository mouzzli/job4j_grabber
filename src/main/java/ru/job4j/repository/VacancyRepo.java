package ru.job4j.repository;

import ru.job4j.model.Vacancy;

public interface VacancyRepo {
    void save(Vacancy vacancy);
}

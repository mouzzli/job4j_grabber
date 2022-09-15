package ru.job4j.service;

import ru.job4j.model.Vacancy;
import ru.job4j.parser.Parser;
import ru.job4j.repository.VacancyRepo;

import java.util.List;

public class VacancyService {

    private final Parser parser;
    private final VacancyRepo repo;

    public VacancyService(Parser parser, VacancyRepo repo) {
        this.parser = parser;
        this.repo = repo;
    }

    public void save() {
        List<Vacancy> vacancyList = parser.getData();
        vacancyList.forEach(repo::save);
    }
}

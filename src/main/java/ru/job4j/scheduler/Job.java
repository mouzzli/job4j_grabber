package ru.job4j.scheduler;

import ru.job4j.service.VacancyService;

public class Job implements Runnable {
    private final VacancyService service;

    public Job(VacancyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.save();
    }
}

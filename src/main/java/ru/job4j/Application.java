package ru.job4j;

import ru.job4j.parser.HabrCareerParser;
import ru.job4j.repository.PostgresJDBCRepo;
import ru.job4j.scheduler.Job;
import ru.job4j.service.VacancyService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ru.job4j.util.Util.getProperty;

public class Application {
    public static void main(String[] args) {
        VacancyService service = new VacancyService(new HabrCareerParser(), new PostgresJDBCRepo());
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Job(service), 0, getPeriod(), TimeUnit.SECONDS);
    }

    private static int getPeriod() {
        return Integer.parseInt(getProperty("period"));
    }

}


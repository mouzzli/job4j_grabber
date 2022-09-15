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
        return id == vacancy.id && company.equals(vacancy.company) && title.equals(vacancy.title) && link.equals(vacancy.link) && description.equals(vacancy.description) && dateTime.equals(vacancy.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, title, link, description, dateTime);
    }
}

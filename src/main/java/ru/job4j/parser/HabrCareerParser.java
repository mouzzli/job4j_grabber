package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.job4j.model.Vacancy;
import ru.job4j.util.Util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParser implements Parser {
    private final String baseLink = "https://career.habr.com/";
    private final String fullLink = String.format("%svacancies/java_developer", baseLink);

    @Override
    public List<Vacancy> getData() {
        List<Vacancy> vacancyList = new ArrayList<>();
        try {
            for (int i = 1; i <= 5; i++) {
                Document document = Jsoup.connect(fullLink + "?page=" + i).get();
                Elements elements = document.getElementsByClass("vacancy-card__inner");
                elements.forEach(element -> {
                    String company = element.getElementsByClass("vacancy-card__company-title").first().child(0).text();
                    LocalDateTime dateTime = Util.parse(element.getElementsByClass("vacancy-card__date").first().child(0).attr("datetime"));
                    String title = element.getElementsByClass("vacancy-card__title").first().text();
                    String link = baseLink + element.getElementsByClass("vacancy-card__title").first().child(0).attr("href");
                    String description = getDescription(link);
                    vacancyList.add(new Vacancy(company, title, link, description, dateTime));
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    private String getDescription(String link) {
        String description = "";
        try {
            Document document = Jsoup.connect(link).get();
            description = document.getElementsByClass("collapsible-description").first().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return description;
    }
}

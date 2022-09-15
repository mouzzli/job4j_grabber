package ru.job4j.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Properties;

public class Util {

    public static LocalDateTime parse(String zoneDateTime) {
        return ZonedDateTime.parse(zoneDateTime).toLocalDateTime();
    }

    public static String getProperty(String property) {
        return loadProperties().getProperty(property);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

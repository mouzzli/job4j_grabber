package ru.job4j.util;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeUtil {

    public static LocalDateTime parse(String zoneDateTime) {
        return ZonedDateTime.parse(zoneDateTime).toLocalDateTime();
    }
}

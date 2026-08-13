package org.example.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtilsHR {
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private DateUtilsHR() {
    }

    public static LocalDate parse(String value) {

        return LocalDate.parse(value, FORMAT);
    }

    public static String format(LocalDate date) {

        if (date == null) {
            return "";
        }

        return date.format(FORMAT);
    }
}

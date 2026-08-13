package org.example.Utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Utility class for handling date operations
public class DateUtil {

    // Date format used in the HR system
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Convert LocalDate to String
    public static String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    // Convert String to LocalDate
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    // Return today's date
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // Check if a date is before today's date
    public static boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    // Check if a date is after today's date
    public static boolean isFutureDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }
}
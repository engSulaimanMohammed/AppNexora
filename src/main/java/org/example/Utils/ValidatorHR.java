package org.example.Utils;

public class ValidatorHR {
    private ValidatorHR() {
    }

    public static boolean isValidScore(double score) {

        return score >= 0 && score <= 100;
    }

    public static boolean isValidEmail(String email) {

        return email != null
                && email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );
    }
}


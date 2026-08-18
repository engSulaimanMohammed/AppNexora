package org.example.Utils;

// Utility class for password operations
public class PasswordUtil {

    // Check if the password is valid
    public static boolean isValidPassword(String password) {

        // Check if password is not null and has at least 8 characters
        return password != null && password.length() >= 8;
    }

    // Check if two passwords match
    public static boolean passwordsMatch(
            String password,
            String confirmPassword) {

        // Compare the two passwords
        return password != null
                && password.equals(confirmPassword);
    }

    // Check if the password contains a number
    public static boolean containsNumber(String password) {

        // Check every character in the password
        for (char character : password.toCharArray()) {

            // Return true if a number is found
            if (Character.isDigit(character)) {
                return true;
            }
        }

        return false;
    }
}
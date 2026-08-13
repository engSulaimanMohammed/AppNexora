package org.example.Utils;


// Utility class for validating user and employee data
public class Validation {

    // Check if a text value is not null or empty
    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    // Check if an email address is valid
    public static boolean isValidEmail(String email) {
        return email != null
                && email.contains("@")
                && email.contains(".");
    }

    // Check if an ID is valid
    public static boolean isValidId(int id) {
        return id > 0;
    }

    // Check if a salary value is valid
    public static boolean isValidSalary(double salary) {
        return salary >= 0;
    }

    // Check if leave balance is valid
    public static boolean isValidLeaveBalance(double balance) {
        return balance >= 0;
    }

    // Check if overtime hours are valid
    public static boolean isValidOvertimeHours(double hours) {
        return hours > 0;
    }

    // Check if employee number is valid
    public static boolean isValidEmployeeNumber(String employeeNumber) {
        return employeeNumber != null
                && !employeeNumber.trim().isEmpty();
    }

    // Check if a status is valid
    public static boolean isValidStatus(String status) {
        return status != null
                && !status.trim().isEmpty();
    }
}
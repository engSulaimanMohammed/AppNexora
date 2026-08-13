package org.example.Utils;

public class NotificationService {
    public void sendNotification(Long employeeId, String message) {
        // Dispatch alerts to target users
        System.out.println("Notification sent to Employee ID " + employeeId + ": " + message);
    }
}

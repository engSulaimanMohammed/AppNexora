package org.example.Services;

import org.example.entities.Notification;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee notifications
public class NotificationService {

    // List to store employee notifications
    private List<Notification> notificationList = new ArrayList<>();

    // Add a new notification
    public void addNotification(Notification notification) {
        notificationList.add(notification);
    }

    // Find a notification using its ID
    public Notification getNotificationById(int notificationId) {

        // Check every notification in the list
        for (Notification notification : notificationList) {

            // Check if the notification ID matches
            if (notification.getNotificationId() == notificationId) {
                return notification;
            }
        }

        // Return null if the notification is not found
        return null;
    }

    // Return all notifications
    public List<Notification> getAllNotifications() {
        return notificationList;
    }

    // Return all notifications for a specific employee
    public List<Notification> getNotificationsByEmployee(int employeeId) {

        // Create a list for the employee notifications
        List<Notification> employeeNotifications = new ArrayList<>();

        // Check every notification
        for (Notification notification : notificationList) {

            // Add notifications that belong to the employee
            if (notification.getEmployeeId() == employeeId) {
                employeeNotifications.add(notification);
            }
        }

        return employeeNotifications;
    }

    // Mark a notification as read
    public void markAsRead(int notificationId) {

        Notification notification = getNotificationById(notificationId);

        if (notification != null) {
            notification.markAsRead();
        }
    }

    // Delete a notification using its ID
    public void deleteNotification(int notificationId) {

        notificationList.removeIf(
                notification -> notification.getNotificationId() == notificationId
        );
    }
}
package org.example.Services;

import org.example.Entities.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationServiceAdmin {

    private final List<Notification> notifications =
            new ArrayList<>();

    public void sendNotification(int employeeId, String message) {

        notifications.add(
                new Notification(employeeId, message)
        );
    }
}

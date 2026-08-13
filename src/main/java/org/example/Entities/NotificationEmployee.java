package org.example.Entities;

public class Notification {

    private int notificationId;
    private int employeeId;
    private String message;
    private String type;
    private boolean read;

    public Notification(
            int notificationId,
            int employeeId,
            String message,
            String type) {

        this.notificationId = notificationId;
        this.employeeId = employeeId;
        this.message = message;
        this.type = type;
        this.read = false;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void markAsRead() {
        this.read = true;
    }
}
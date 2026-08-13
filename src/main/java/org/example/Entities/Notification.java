package org.example.Entities;

import java.time.LocalDateTime;

public class Notification {

    private int employeeId;
    private String message;
    private LocalDateTime createdAt;
    private boolean read;

    public Notification(int employeeId, String message) {
        this.employeeId = employeeId;
        this.message = message;
        this.createdAt = LocalDateTime.now();
        this.read = false;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isRead() {
        return read;
    }

    public void markAsRead() {
        read = true;
    }


}

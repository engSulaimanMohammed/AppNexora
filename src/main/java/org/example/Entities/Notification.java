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


}

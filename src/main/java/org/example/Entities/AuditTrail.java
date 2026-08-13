package org.example.Entities;

import java.time.LocalDateTime;

public class AuditTrail {

    private String action;
    private String username;
    private LocalDateTime timestamp;

    public AuditTrail(String action, String username) {
        this.action = action;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }

}

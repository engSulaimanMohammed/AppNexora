package org.example.Entities;

public class UserHR {

    private int userId;
    private int employeeId;

    private String username;
    private String password;
    private String role;

    private boolean active;

    public UserHR(
            int userId,
            int employeeId,
            String username,
            String password,
            String role,
            boolean active) {

        this.userId = userId;
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }
}

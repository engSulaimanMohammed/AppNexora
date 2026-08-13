package org.example.Entities;

/**
 * A system account used to sign in. EMPLOYEE accounts are linked to an
 * {@link Employee} record through {@link #employeeId}; ADMIN and HR accounts
 * leave it {@code null}.
 */
public class User {

    private final int id;
    private final String username;
    private String password;
    private final String email;
    private final Role role;
    private final Integer employeeId;

    public User(int id, String username, String password, String email, Role role, Integer employeeId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
}

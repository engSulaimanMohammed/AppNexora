package org.example.Entities;

public class Company {

    private Long id;
    private String name;
    private String userRole;
    private int employeeCount;


    public Company() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Company(Long id, String name, String userRole, int employeeCount) {

        this.id = id;
        this.name = name;
        this.userRole = userRole;
        this.employeeCount = employeeCount;


    }
}

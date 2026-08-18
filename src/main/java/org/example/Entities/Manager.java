package org.example.Entities;

public class Manager extends User {

    private String managerNumber;
    private String name;
    private String email;
    private String department;

    public Manager(
            int id,
            String username,
            String password,
            String role,
            String managerNumber,
            String name,
            String email,
            String department) {

        super(id, username, password, role);

        this.managerNumber = managerNumber;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
package org.example.Entities;


public class Employee extends User {

    private String employeeNumber;
    private String name;
    private String email;
    private String department;
    private String position;
    private double leaveBalance;

    public Employee(int id, String username, String password, String role, String email) {
        super(id, username, password, role, email);
    }
}

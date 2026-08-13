package org.example.Entities;

public class Employee extends User {

    private String employeeNumber;
    private String name;
    private String email;
    private String department;
    private String position;
    private double leaveBalance;
    private double sickLeaveBalance;

    public Employee(
            int id,
            String username,
            String password,
            String role,
            String employeeNumber,
            String name,
            String email,
            String department,
            String position,
            double leaveBalance,
            double sickLeaveBalance) {

        super(id, username, password, role);

        this.employeeNumber = employeeNumber;
        this.name = name;
        this.email = email;
        this.department = department;
        this.position = position;
        this.leaveBalance = leaveBalance;
        this.sickLeaveBalance = sickLeaveBalance;
    }


package org.example.Entities;

public class Employee {

    private final int id;
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


    public Employee(int id, String name, String email, String department, String position, double leaveBalance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.position = position;
        this.leaveBalance = leaveBalance;
        this.sickLeaveBalance = sickLeaveBalance;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;

    }

    public int getId() {
        return id;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }


    public double getSickLeaveBalance() {
        return sickLeaveBalance;
    }

    public void setSickLeaveBalance(double sickLeaveBalance) {
        this.sickLeaveBalance = sickLeaveBalance;
    }
}

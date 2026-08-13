package org.example.Entities;

public class PayrollEmployee {

    private int payrollId;
    private int employeeId;
    private String month;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;

    public PayrollEmployee(
            int payrollId,
            int employeeId,
            String month,
            double basicSalary,
            double allowances,
            double deductions) {

        this.payrollId = payrollId;

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
        this.employeeId = employeeId;
        this.month = month;
        this.basicSalary = basicSalary;

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
        calculateNetSalary();
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
        calculateNetSalary();
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
        calculateNetSalary();
    }

    public double getNetSalary() {
        return netSalary;
    }

    private void calculateNetSalary() {
        netSalary = basicSalary + allowances - deductions;
    }

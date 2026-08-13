package org.example.Entities;

public class Payroll {

    private final int employeeId;
    private final double baseSalary;
    private final double allowances;
    private final double deductions;

    public Payroll(int employeeId, double baseSalary, double allowances, double deductions) {
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getAllowances() {
        return allowances;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetSalary() {
        return baseSalary + allowances - deductions;
    }
}

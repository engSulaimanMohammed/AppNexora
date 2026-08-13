package org.example.Entities;

public class PayrollEmployee {

    private int payrollId;
    private int employeeId;

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

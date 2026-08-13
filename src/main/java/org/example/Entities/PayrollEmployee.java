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
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = basicSalary + allowances - deductions;
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


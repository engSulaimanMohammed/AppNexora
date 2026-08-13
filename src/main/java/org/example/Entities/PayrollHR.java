package org.example.Entities;

import java.time.LocalDate;

public class PayrollHR {

    private int payrollId;
    private int employeeId;

    private String month;

    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;

    private String status;

    private LocalDate paymentDate;

    public PayrollHR(
            int payrollId,
            int employeeId,
            String month,
            double basicSalary,
            double allowances,
            double deductions,
            String status,
            LocalDate paymentDate) {

        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.month = month;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = calculateNetSalary();
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public double calculateNetSalary() {
        return basicSalary + allowances - deductions;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getMonth() {
        return month;
    }

    public double getNetSalary() {
        return netSalary;
    }
}

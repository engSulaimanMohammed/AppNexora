package org.example.Interfaces;

import org.example.Entities.Payroll;

import java.util.List;

public interface PayrollService {

    void addPayroll(Payroll payroll);

    Payroll getPayrollById(int payrollId);

    List<Payroll> getAllPayrolls();

    List<Payroll> getPayrollsByEmployee(int employeeId);

    List<Payroll> getPayrollsByMonth(String month);

    boolean updatePayroll(Payroll payroll);

    boolean deletePayroll(int payrollId);

    double calculateTotalPayroll(String month);

    int getCalculatedEmployees(String month);

    int getTotalEmployeesForPayroll(String month);
}

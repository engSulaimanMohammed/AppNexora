package org.example.Interfaces;

import org.example.Entities.PayrollHR;
import org.example.Entities.PerformanceHR;

import java.util.List;

public interface PayrollServiceHR {

    void addPayroll(PerformanceHR payroll);

    void addPayroll(PayrollHR payroll);

    List<PayrollHR> getAllPayrolls();

    double calculateTotalPayroll(String month);
}

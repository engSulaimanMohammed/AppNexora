package org.example.Services;

import org.example.entities.Payroll;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employee payroll
public class PayrollService {

    // List to store payroll records
    private List<Payroll> payrollList = new ArrayList<>();

    // Add a new payroll record
    public void addPayroll(Payroll payroll) {
        payrollList.add(payroll);
    }

    // Find a payroll record using its ID
    public Payroll getPayrollById(int payrollId) {

        // Check every payroll record in the list
        for (Payroll payroll : payrollList) {

            // Check if the payroll ID matches
            if (payroll.getPayrollId() == payrollId) {
                return payroll;
            }
        }

        // Return null if the payroll record is not found
        return null;
    }

    // Return all payroll records
    public List<Payroll> getAllPayrolls() {
        return payrollList;
    }

    // Return all payroll records for a specific employee
    public List<Payroll> getPayrollByEmployee(int employeeId) {

        // Create a list for the employee payroll records
        List<Payroll> employeePayrolls = new ArrayList<>();

        // Check every payroll record
        for (Payroll payroll : payrollList) {

            // Add payroll records that belong to the employee
            if (payroll.getEmployeeId() == employeeId) {
                employeePayrolls.add(payroll);
            }
        }

        return employeePayrolls;
    }

    // Update an existing payroll record
    public void updatePayroll(Payroll updatedPayroll) {

        for (int i = 0; i < payrollList.size(); i++) {

            if (payrollList.get(i).getPayrollId()
                    == updatedPayroll.getPayrollId()) {

                payrollList.set(i, updatedPayroll);
                return;
            }
        }
    }

    // Delete a payroll record using its ID
    public void deletePayroll(int payrollId) {

        payrollList.removeIf(
                payroll -> payroll.getPayrollId() == payrollId
        );
    }
}
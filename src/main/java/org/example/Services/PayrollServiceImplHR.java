package org.example.Services;
import org.example.Entities.PayrollHR;
import org.example.Interfaces.PayrollServiceHR;

import java.util.ArrayList;
import java.util.List;

public abstract class PayrollServiceImplHR implements PayrollServiceHR{
    private final List<PayrollHR> payrolls =
            new ArrayList<>();

    @Override
    public void addPayroll(PayrollHR payroll) {

        if (payroll != null) {
            payrolls.add(payroll);
        }
    }

    @Override
    public List<PayrollHR> getAllPayrolls() {
        return new ArrayList<>(payrolls);
    }

    @Override
    public double calculateTotalPayroll(String month) {

        double total = 0;

        for (PayrollHR payroll : payrolls) {

            if (payroll.getMonth()
                    .equalsIgnoreCase(month)) {

                total += payroll.getNetSalary();
            }
        }

        return total;
    }
}



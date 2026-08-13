package org.example.Services;

import org.example.Entities.Payroll;
import org.example.Interfaces.PayrollService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PayrollServiceImpl implements PayrollService {

    private final Map<Integer, Payroll> payrolls = new HashMap<>();

    public PayrollServiceImpl() {
        payrolls.put(1, new Payroll(1, 9000, 1500, 700));
        payrolls.put(2, new Payroll(2, 6500, 900, 500));
        payrolls.put(3, new Payroll(3, 7200, 1000, 600));
    }

    @Override
    public Optional<Payroll> findByEmployee(int employeeId) {
        return Optional.ofNullable(payrolls.get(employeeId));
    }
}

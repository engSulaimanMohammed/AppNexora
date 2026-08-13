package org.example.Interfaces;

import org.example.Entities.Payroll;

import java.util.Optional;

public interface PayrollService {

    Optional<Payroll> findByEmployee(int employeeId);
}

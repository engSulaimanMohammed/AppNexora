package org.example.Interfaces;

import org.example.Entities.HREmployee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(HREmployee HREmployee);

    HREmployee getEmployeeById(int employeeId);

    List<HREmployee> getAllEmployees();

    boolean updateEmployee(HREmployee HREmployee);

    boolean deleteEmployee(int employeeId);

    List<HREmployee> searchEmployees(String keyword);

    int getTotalEmployees();
}

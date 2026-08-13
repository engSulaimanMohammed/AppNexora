package org.example.Services;



import org.example.Entities.Employee;
import org.example.Interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
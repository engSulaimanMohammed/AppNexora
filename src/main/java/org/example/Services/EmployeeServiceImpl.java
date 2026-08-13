package org.example.Services;

import org.example.Entities.Employee;
import org.example.Interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public EmployeeServiceImpl() {
        seed("Sara Nasser", "sara@nexora.com", "Management", "Administrator", 21);
        seed("Ahmed Fathi", "ahmed@nexora.com", "Human Resources", "HR Specialist", 18);
        seed("Khaled Omar", "khaled@nexora.com", "Engineering", "Software Engineer", 15);
    }

    private void seed(String name, String email, String department, String position, double leaveBalance) {
        employees.add(new Employee(nextId++, name, email, department, position, leaveBalance));
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public Employee add(String name, String email, String department, String position) {
        Employee employee = new Employee(nextId++, name, email, department, position, 21);
        employees.add(employee);
        return employee;
    }

    @Override
    public boolean remove(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}

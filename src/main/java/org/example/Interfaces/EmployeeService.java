package org.example.Interfaces;

import org.example.Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(int id);

    Employee add(String name, String email, String department, String position);

    boolean remove(int id);
}

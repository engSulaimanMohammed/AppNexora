package org.example.Services;



import org.example.entities.Employee;
import java.util.ArrayList;
import java.util.List;

// Service class for managing employees
public class EmployeeService {

    // List to store employees
    private List<Employee> employeeList = new ArrayList<>();

    // Add a new employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Find an employee using the employee ID
    public Employee getEmployeeById(int employeeId) {

        // Check every employee in the list
        for (Employee employee : employeeList) {

            // Check if the employee ID matches
            if (employee.getId() == employeeId) {
                return employee;
            }
        }

        // Return null if the employee is not found
        return null;
    }

    // Find an employee using the employee number
    public Employee getEmployeeByNumber(String employeeNumber) {

        // Check every employee in the list
        for (Employee employee : employeeList) {

            // Check if the employee number matches
            if (employee.getEmployeeNumber().equals(employeeNumber)) {
                return employee;
            }
        }

        // Return null if the employee is not found
        return null;
    }

    // Return all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Update an existing employee
    public void updateEmployee(Employee updatedEmployee) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId() == updatedEmployee.getId()) {

                employeeList.set(i, updatedEmployee);
                return;
            }
        }
    }

    // Delete an employee using the employee ID
    public void deleteEmployee(int employeeId) {

        employeeList.removeIf(
                employee -> employee.getId() == employeeId
        );
    }
}
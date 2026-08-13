package org.example.Services;

import org.example.Entities.Employee;
import org.example.Entities.Report;

import java.util.List;

public class ReportServiceAdmin {

    private final EmployeeService employeeService;

    public ReportServiceAdmin(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Report generateEmployeeReport() {

        List<Employee> employees =
                employeeService.getAllEmployees();

        StringBuilder content = new StringBuilder();

        content.append("Total Employees: ")
                .append(employees.size())
                .append("\n\n");

        for (Employee employee : employees) {
            content.append(employee)
                    .append("\n");
        }

        return new Report(
                "Employee Report",
                content.toString()
        );
    }
}





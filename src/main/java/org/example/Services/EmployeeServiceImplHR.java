package org.example.Services;

import org.example.Entities.HREmployee;
import org.example.Interfaces.EmployeeServiceHR;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImplHR implements EmployeeServiceHR {
    private final List<HREmployee> employees = new ArrayList<>();

    @Override
    public void addEmployee(HREmployee employee) {

        if (employee != null &&
                getEmployeeById(employee.getEmployeeId()) == null) {

            employees.add(employee);
        }
    }

    @Override
    public HREmployee getEmployeeById(int id) {

        for (HREmployee employee : employees) {

            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public List<HREmployee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public List<HREmployee> searchEmployees(String keyword) {

        List<HREmployee> result = new ArrayList<>();

        if (keyword == null) {
            return result;
        }

        String search = keyword.toLowerCase();

        for (HREmployee employee : employees) {

            if (employee.getFullName().toLowerCase().contains(search)
                    || employee.getDepartment().toLowerCase().contains(search)
                    || employee.getJobTitle().toLowerCase().contains(search)) {

                result.add(employee);
            }
        }

        return result;
    }

    @Override
    public boolean deleteEmployee(int id) {

        HREmployee employee = getEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
            return true;
        }

        return false;
    }

    @Override
    public int getTotalEmployees() {
        return employees.size();
    }
}


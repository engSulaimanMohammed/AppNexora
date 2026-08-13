package org.example.Interfaces;

import org.example.Entities.HREmployee;

import java.util.List;

public interface EmployeeServiceHR {


    void addEmployee(HREmployee employee);

    HREmployee getEmployeeById(int id);

    List<HREmployee> getAllEmployees();

    List<HREmployee> searchEmployees(String keyword);

    boolean deleteEmployee(int id);

    int getTotalEmployees();

    public interface EmployeeService {

        void addEmployee(HREmployee HRemployee);

        HREmployee getEmployeeById(int id);

        List<HREmployee> getAllEmployees();

        List<HREmployee> searchEmployees(String keyword);

        boolean deleteEmployee(int id);

        int getTotalEmployees();
    }
}

package org.example.Entities;

public class Department {

    private int departmentId;
    private String departmentName;
    private String managerName;
    private String location;

    public Department(
            int departmentId,
            String departmentName,
            String managerName,
            String location) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


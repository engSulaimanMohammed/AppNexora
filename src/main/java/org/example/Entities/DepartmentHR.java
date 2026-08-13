package org.example.Entities;

public class DepartmentHR {

    private int departmentId;
    private String departmentName;
    private String managerName;
    private String description;

    public DepartmentHR(
            int departmentId,
            String departmentName,
            String managerName,
            String description) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.description = description;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getDescription() {
        return description;
    }
}

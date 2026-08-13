package org.example.Entities;

public class AdminEmployee {

    private  long id;
    private  String name;
    private String email;
    private String department;

    public AdminEmployee(String department, String email, String name, long id) {
        this.department = department;
        this.email = email;
        this.name = name;
        this.id = id;
    }
}

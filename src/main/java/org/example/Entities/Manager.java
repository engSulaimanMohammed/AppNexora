package org.example.Entities;

public class Manager extends User {

    private String managerNumber;
    private String name;
    private String email;
    private String department;

    public Manager(
            int id,
            String username,
            String password,
            String role,
            String managerNumber,
            String name,
            String email,
            String department) {

        super(id, username, password, role);

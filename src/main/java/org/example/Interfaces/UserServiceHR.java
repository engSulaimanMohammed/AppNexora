package org.example.Interfaces;

import org.example.Entities.UserHR;

import java.util.List;

public interface UserServiceHR {

    void addUser(UserServiceHR user);

    List<UserServiceHR> getAllUsers();

    boolean login(String username, String password);
}
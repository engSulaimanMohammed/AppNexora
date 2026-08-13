package org.example.Interfaces;

import org.example.Entities.UserHR;

import java.util.List;

public interface UserService {

    void addUser(UserHR userHR);

    UserHR getUserById(int userId);

    UserHR getUserByUsername(String username);

    List<UserHR> getAllUsers();

    boolean updateUser(UserHR userHR);

    boolean deleteUser(int userId);

    boolean login(String username, String password);

    boolean activateUser(int userId);

    boolean deactivateUser(int userId);
}

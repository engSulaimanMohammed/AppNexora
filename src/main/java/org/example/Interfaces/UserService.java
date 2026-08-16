package org.example.Interfaces;

import org.example.Entities.User;

public interface UserService {

    User authenticate(String username, String password);

    boolean resetPassword(String username, String newPassword);

    boolean emailExists(String email);
}
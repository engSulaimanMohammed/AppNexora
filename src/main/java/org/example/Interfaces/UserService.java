package org.example.Interfaces;

import org.example.Entities.User;

public interface UserService {
    User authenticateCredentials(String username, String password);
    boolean handleForgotPassword(String username, String newPassword);
}
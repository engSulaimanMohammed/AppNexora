package org.example.Services;

import org.example.Entities.User;
import org.example.Interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        // حسابات باسم مستخدم (نص) وكلمة مرور (أرقام):
        users.add(new User("Sara", "112233", "sara@company.com", "ADMIN"));
        users.add(new User("Ahmed", "445566", "ahmed@company.com", "HR"));
        users.add(new User("Khaled", "778899", "khaled@company.com", "EMPLOYEE"));
    }

    @Override
    public User authenticateCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean handleForgotPassword(String username, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }
}
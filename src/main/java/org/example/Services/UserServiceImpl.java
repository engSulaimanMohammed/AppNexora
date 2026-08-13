package org.example.Services;

import org.example.Entities.User;
import org.example.Interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        // حسابات باسم مستخدم (نص) وكلمة مرور (أرقام):
        users.add(new User(1,"Sara", "112233",  "ADMIN", "sara@example.com"));
        users.add(new User(2, "Ahmed", "445566",  "HR", "ahmed@example.com"));
        users.add(new User(3,"Khaled", "778899", "EMPLOYEE", "khaled@example.com"));
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
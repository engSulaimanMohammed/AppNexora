package org.example.Services;

import org.example.Entities.Role;
import org.example.Entities.User;
import org.example.Interfaces.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public UserServiceImpl() {
        // Seed accounts. EMPLOYEE accounts map to the employees seeded in EmployeeServiceImpl.
        users.add(new User(nextId++, "admin@Appnwxora.com", "Admin@123", "admin@nexora.com", Role.ADMIN, null));
        users.add(new User(nextId++, "hr@Appnwxora.com", "Hr@123", "hr@nexora.com", Role.HR, null));
        users.add(new User(nextId++, "sara@Appnwxora.com", "Sara@123", "sara@nexora.com", Role.EMPLOYEE, 1));
        users.add(new User(nextId++, "ahmed@Appnwxora.com", "Ahmed@123", "ahmed@nexora.com", Role.EMPLOYEE, 2));
        users.add(new User(nextId++, "khaled@Appnwxora.com", "Khaled@123", "khaled@nexora.com", Role.EMPLOYEE, 3));
    }

    @Override
    public User authenticate(String username, String password) {
        return findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    @Override
    public boolean resetPassword(String username, String newPassword) {
        return findByUsername(username)
                .map(user -> {
                    user.setPassword(newPassword);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public void resetPassword(User user) {

    }

    private Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
}

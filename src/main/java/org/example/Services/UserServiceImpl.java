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

        users.add(new User(
                nextId++,
                "admin",
                "Admin@123",
                "admin@Appnwxora.com",
                Role.ADMIN,
                null
        ));

        users.add(new User(
                nextId++,
                "hr",
                "Hremployee@123",
                "hr@Appnwxora.com",
                Role.HR,
                null
        ));

        users.add(new User(
                nextId++,
                "sara",
                "Sara@123",
                "sara@Appnwxora.com",
                Role.EMPLOYEE,
                1
        ));

        users.add(new User(
                nextId++,
                "ahmed",
                "Ahmed@123",
                "ahmed@Appnwxora.com",
                Role.EMPLOYEE,
                2
        ));

        users.add(new User(
                nextId++,
                "khaled",
                "Khaled@123",
                "khaled@Appnwxora.com",
                Role.EMPLOYEE,
                3
        ));
    }

    @Override
    public User authenticate(
            String username,
            String password) {

        return findByUsername(username)
                .filter(user ->
                        user.getPassword()
                                .equals(password)
                )
                .orElse(null);
    }

    @Override
    public boolean resetPassword(
            String username,
            String newPassword) {

        return findByUsername(username)
                .map(user -> {

                    user.setPassword(newPassword);

                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean emailExists(String email) {

        return users.stream()
                .anyMatch(user ->
                        user.getUsername()
                                .equalsIgnoreCase(email)
                                ||
                                user.getEmail()
                                        .equalsIgnoreCase(email)
                );
    }

    private Optional<User> findByUsername(
            String username) {

        return users.stream()
                .filter(user ->
                        user.getUsername()
                                .equalsIgnoreCase(username)
                )
                .findFirst();
    }
}
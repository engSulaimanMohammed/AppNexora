package org.example.Services;

import org.example.entities.User;
import java.util.ArrayList;
import java.util.List;

// Service class for managing user authentication
public class AuthenticationService {

    // List to store users
    private List<User> users = new ArrayList<>();

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Login using username and password
    public User login(String username, String password) {

        // Check every user in the list
        for (User user : users) {

            // Check if username and password are correct
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        // Return null if login information is incorrect
        return null;
    }

    // Check if a username already exists
    public boolean usernameExists(String username) {

        for (User user : users) {

            if (user.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    // Logout the current user
    public void logout() {
        System.out.println("User logged out successfully.");
    }
}
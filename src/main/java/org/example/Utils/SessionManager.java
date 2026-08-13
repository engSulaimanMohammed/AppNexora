package org.example.Utils;

package com.hr.utils;

import org.example.entities.User;

// Utility class for managing the current user session
public class SessionManager {

    // Store the currently logged-in user
    private static User currentUser;

    // Set the current user after successful login
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    // Return the currently logged-in user
    public static User getCurrentUser() {
        return currentUser;
    }

    // Check if a user is currently logged in
    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    // Clear the current user session
    public static void logout() {
        currentUser = null;
    }
}
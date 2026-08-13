package org.example;

import org.example.Entities.User;
import org.example.Interfaces.UserService;
import org.example.Services.AuthService;
import org.example.Services.UserServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserServiceImpl();


        IO.println("*****   Enterprise Management System*****   ");


        User currentUser = null;

        while (currentUser == null) {
            IO.println("\n1. Sign In");
            IO.println("2. Forgot Password");
            IO.println("3. Exit System");
            IO.print("Select an option: ");

            int option = readInt(scanner);

            if (option == 1) {
                IO.print("Username: ");
                String username = scanner.nextLine();
                IO.print("Password: ");
                String password = scanner.nextLine();

                currentUser = userService.authenticateCredentials(username, password);

                if (currentUser != null) {
                    AuthService.setCurrentUser(currentUser);
                    IO.println("✅ Login successful! Access granted.");
                } else {
                    IO.println("❌ Invalid username or password!");
                }

            } else if (option == 2) {
                IO.print("Enter your username: ");
                String username = scanner.nextLine();
                IO.print("Enter new password: ");
                String newPassword = scanner.nextLine();

                if (userService.handleForgotPassword(username, newPassword)) {
                    IO.println("✅ Password reset successful! You can now sign in.");
                } else {
                    IO.println("❌ Username not found!");
                }
            } else {
                IO.println("❌ Invalid option!");
            }
        }

        IO.println("\nWelcome, " + currentUser.getUsername() + " | Role: [" + currentUser.getRole() + "]");

        switch (currentUser.getRole().toUpperCase()) {
            case "ADMIN":
                IO.println("\n--- ADMIN PANEL ---");
                break;
            case "HR":
                IO.println("\n--- HR DASHBOARD ---");
                break;
            case "EMPLOYEE":
                IO.println("\n--- EMPLOYEE PORTAL ---");
                break;
        }

        AuthService.logout();
        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            IO.print("❌ Enter a valid number: ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
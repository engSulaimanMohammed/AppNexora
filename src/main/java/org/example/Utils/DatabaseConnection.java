package org.example.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class for managing the database connection
public class DatabaseConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/hr_system";

    // Database username
    private static final String USER = "root";

    // Database password
    private static final String PASSWORD = "password";

    // Create and return a connection to the database
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
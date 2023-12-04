package com.Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // JDBC URL, username, and password of MySQL server
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/TP1Web";
    private static final String dbUser = "root";
    private static final String dbPassword = "password";

    // Load the JDBC driver during class initialization
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception properly in a real-world scenario
        }
    }

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }
}

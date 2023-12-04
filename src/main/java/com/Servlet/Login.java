package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/TP1Web";
    private static final String dbUser = "root";
    private static final String dbPassword = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(" "+ username +" "+ password);
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception properly in a real-world scenario
            return; // Return to avoid proceeding with the database connection if driver not found
        }

        try {
            // Open a connection
            try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
                String query = "SELECT * FROM users WHERE username=? AND password_hash=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    // Execute the query
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        
                        if (resultSet.next()) {
                            
                            System.out.println("User Valid"); 
                            response.sendRedirect("welcome.jsp");	
                            return;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        // Authentication failed
        System.out.println("User Unvalid"); 
        response.sendRedirect("Error.jsp");	
    }
}




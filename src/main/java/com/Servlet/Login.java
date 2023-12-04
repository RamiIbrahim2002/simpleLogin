package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(username, password);

        if (isValidUser(user)) {
            // Authentication successful
            response.sendRedirect("welcome.jsp"); // Redirect to a welcome page
        } else {
            // Authentication failed
            response.sendRedirect("Error.jsp"); // Redirect back to the login page with an error parameter
        }
    }

    private boolean isValidUser(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM users WHERE username=? AND password_hash=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            	System.out.println(user.getLogin());
            	System.out.println(user.getPassword());
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions properly in a real-world scenario
            return false;
        }
    }
}

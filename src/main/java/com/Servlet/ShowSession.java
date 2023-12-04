package com.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // Check if the user is a returning user
        if (session.isNew()) {
            // If it's a new session, ask for full name and date of birth
            out.println("<html><body>");
            out.println("<h2>Welcome to the website!</h2>");
            out.println("<form action='ShowSession' method='post'>");
            out.println("Full Name: <input type='text' name='fullName'><br>");
            out.println("Date of Birth (yyyy-MM-dd): <input type='text' name='dob'><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            // If it's a returning user, compute days to birthday
            String fullName = (String) session.getAttribute("fullName");
            String dobString = (String) session.getAttribute("dob");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dob = dateFormat.parse(dobString);
                Date currentDate = new Date();
                int daysToBirthday = computeDaysToBirthday(currentDate, dob);

                // Display the message to the user
                out.println("<html><body>");
                out.println("<h2>Hi, " + fullName + "!</h2>");
                out.println("There are " + daysToBirthday + " days to your birthday.");
                out.println("</body></html>");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input from the form
        String fullName = request.getParameter("fullName");
        String dob = request.getParameter("dob");

        // Store user information in the session
        HttpSession session = request.getSession();
        session.setAttribute("fullName", fullName);
        session.setAttribute("dob", dob);

        // Redirect to doGet for further processing
        response.sendRedirect("ShowSession");
    }

    private int computeDaysToBirthday(Date currentDate, Date dob) {
        // Logic to compute the number of days to the next birthday
        // (You can customize this based on your requirements)
        // For simplicity, let's assume the birthday is in the current year

        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(currentDate);

        Calendar dobCal = Calendar.getInstance();
        dobCal.setTime(dob);
        dobCal.set(Calendar.YEAR, currentCal.get(Calendar.YEAR));

        if (currentCal.after(dobCal)) {
            dobCal.add(Calendar.YEAR, 1);
        }

        long diffMillis = dobCal.getTimeInMillis() - currentCal.getTimeInMillis();
        return (int) TimeUnit.MILLISECONDS.toDays(diffMillis);
    }
}

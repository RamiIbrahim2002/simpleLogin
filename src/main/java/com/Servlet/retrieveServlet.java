package com.Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class retrieveServlet extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String birthDate = req.getParameter("birthDate");
        String gender = req.getParameter("gender");
        
        Cookie cookieFirstName = new Cookie("firstName",firstName);
        Cookie cookieLastName = new Cookie("lastName",lastName);
        Cookie cookieBirthDate = new Cookie("birthDate",birthDate);
        Cookie cookieGender = new Cookie("gender",gender);

        res.addCookie(cookieFirstName);
        res.addCookie(cookieLastName);
        res.addCookie(cookieBirthDate);
        res.addCookie(cookieGender);

		res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head><title>User Information</title></head>");
        out.println("<body>");
        out.println("<h2>User Information</h2>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Field</th><th>Value</th></tr>");
        out.println("<tr><td>First Name</td><td>" + firstName + "</td></tr>");
        out.println("<tr><td>Last Name</td><td>" + lastName + "</td></tr>");
        out.println("<tr><td>Birth Date</td><td>" + birthDate + "</td></tr>");
        out.println("<tr><td>Gender</td><td>" + gender + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }
		


	}


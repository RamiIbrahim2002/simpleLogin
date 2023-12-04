package com.Servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class countingVisitsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		
		Cookie[] cookies = req.getCookies();

        // Initialize the visit count
        int visitCount = 1;

        // Check if the "visitCount" cookie exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitCount".equals(cookie.getName())) {
                    // If the cookie exists, parse its value
                    visitCount = Integer.parseInt(cookie.getValue());
                    // Increment the visit count
                    visitCount++;
                    break;
                }
            }
        }
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        
        res.addCookie(visitCookie);
        PrintWriter out = res.getWriter();
        out.print(visitCount);


	}

}

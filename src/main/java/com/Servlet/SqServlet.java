package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();	
		out.println("Hello sq");
		
		int x = (int)request.getAttribute("x");
		int k = 0;

		Cookie cookie[] = request.getCookies();
		for (Cookie c : cookie) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		
		x = x*x ;
		k = k*k;
		out.println("Result = "+x);
		out.println("Result of cookie = "+k);
	}

}

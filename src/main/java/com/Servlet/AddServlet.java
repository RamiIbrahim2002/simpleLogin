package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));
		
		int x = a + b;
		int k = a + b ;
		
		// Cookie cookie = new Cookie("k",k+"");
		// response.addCookie(cookie);
		
		// request.setAttribute("x",x);
		// RequestDispatcher rd = request.getRequestDispatcher("sq");
		// rd.forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor = cyan >");
		out.println("Output = " + k);
		out.print("</body></html>");
		

	}

}

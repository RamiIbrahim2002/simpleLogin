package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String tmp;
        PrintWriter out = res.getWriter();
        int i = 0;
		Cookie cookies [] = req.getCookies();
		for (Cookie c :cookies) {
			tmp = c.getValue();
			out.println(tmp);
		}
	}

}

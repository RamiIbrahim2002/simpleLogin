package com.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the item from the form
        String newItem = request.getParameter("newItem");

        // Get the user's session
        HttpSession session = request.getSession();

        // Get the list of items from the session or create a new one if it doesn't exist
        @SuppressWarnings("unchecked")
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");
        if (itemList == null) {
            itemList = new ArrayList<>();
            session.setAttribute("itemList", itemList);
        }

        // Add the new item to the list
        if (newItem != null && !newItem.isEmpty()) {
            itemList.add(newItem);
        }

        // Display the content of the list
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Items List</title></head><body>");
        out.println("<h2>Items List:</h2>");
        out.println("<ul>");
        int i= 0;
        for (String item : itemList) {
            out.println("<li>" +i+" - "+ item + "</li>");
            i++;
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}

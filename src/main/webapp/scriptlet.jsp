<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My current Time</title>
</head>
<body>
<h1>The current time</h1>
<%@ page import="java.util.Date" %>
<%! Date mydate = new Date(); %>
<p><%= mydate.toString() %></p>
<p><%= request.getRemoteHost() %>
</body>
</html>
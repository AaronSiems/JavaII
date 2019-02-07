<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Convert cans to cash</title>
</head>
<body>
	<h3>Determine the value of your cans</h3>
	<form action="getCansValueServlet" method="post">
	How many cans do you have?:
	<input type="text" name="cans" size="8">
	<input type="submit" value="Calculate value" />
	</form>
	<br/>
	<a href="index.jsp">Return to home</a>
</body>
</html>
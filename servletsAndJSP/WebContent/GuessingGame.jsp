<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guessing game</title>
</head>
<body>
	<h3>Guessing game</h3>
	<form action="compareGuessServlet" method="post">
	Guess my number (1-100):
	<input type="text" name="userGuess" size="5">
	<input type="submit" value="Submit Guess" />
	</form>
	<br/>
	<a href="index.jsp">Return to home</a>
</body>
</html>
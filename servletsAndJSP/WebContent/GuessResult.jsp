<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${userGuess.getResult()}</p>
	
	
	<a href="GuessingGame.jsp">Try again?</a>
	<a href="index.jsp">Return to home</a>
</body>
</html>
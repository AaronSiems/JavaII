<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new collection</title>
</head>
<body>
<form action="createNewCollectionServlet" method="post">
Collection Name: <input type="text" name="name"><br/>

Available Coins: <br/>
<select name="allCoinsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentcoin">
	<option value="${currentcoin.id}">${currentcoin.mint} ${currentcoin.coin} | ${currentcoin.year}</option>
</c:forEach>
</select><br/>
<input type = "submit" value="Create collection and add coins">
</form>
<a href="index.html">Go add a new coin instead.</a>
</body>
</html>
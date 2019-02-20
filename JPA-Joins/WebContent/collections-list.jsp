<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All collections</title>
</head>
<body>

<form method = "post" action = "collectionNavServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="current">
	<tr>
		<td><input type="radio" name="id" value="${current.id}"></td>
		<td><h2>${current.name}</h2></td></tr>
	</tr>
	<c:forEach var = "listVal" items="${current.listOfCoins}">
		<tr><td></td><td colspan="3">${listVal.coin}, from ${listVal.year}, minted at ${listVal.mint}</td></tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type = "submit" value = "add" name="doThisToItem">
</form>

<a href="addCoinsForCollectionServlet"> Create a new collection</a><br/>
<a href="index.html">Insert a new coin</a>
</body>
</html>
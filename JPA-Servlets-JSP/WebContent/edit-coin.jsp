<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a coin</title>
</head>
<body>
	<form action = "editCoinServlet" method="post">
		Coin: <input type = "text" name = "coin" value = "${coinToEdit.coin}">
		Year: <input type = "text" name = "year" value = "${coinToEdit.year}">
		Mint: <input type = "text" name = "mint" value = "${coinToEdit.mint}">
		<input type = "hidden" name = "id" value = "${coinToEdit.id}">
		<input type = "submit" value = "Save Edited Coin">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/webProject/RegisterVisiteur" method="Post">
	<p>email</p><input type="text" id="email" name="email">
	<p>nom</p><input type="text" id="firstName" name="firstName">
	<p>prenom</p><input type="text" id="lastName" name="lastName">
	<p>telephone</p><input type="text" id="phone" name="phone">
	<p>adresse</p><input type="text" id="address" name="address">
	<p>mot de passe</p><input type="text" id="password" name="password">
	<p>confirmer mot de passe</p><input type="text" id="confPassword" name="confPassword">
	
	<input type="submit" value="Insert user">
	</form>
</body>
</html>
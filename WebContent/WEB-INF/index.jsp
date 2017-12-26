<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Welcome to Class Royale !</h3>
		
		<form action="/combat">
			<p>
				<label for="name">Nom de votre personnage :</label>
				<input type="text" name="name">
			</p>
			<p>
				<label for="type">Quelle classe voulez-vous jouer ?</label>
				<select name="type">
					<option value="archer">Archer</option>
					<option value="mage">Mage</option>
					<option value="guerrier">Guerrier</option>
				</select>
			</p>
			<p>
				<input type="submit" value="Go !">
			</p>
		</form>
	</body>
</html>
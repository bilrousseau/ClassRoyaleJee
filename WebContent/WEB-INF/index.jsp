<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param value="Bienvenue !" name="title" />
	</jsp:include>
	<body>
		<h3>Welcome to Class Royale !</h3>
		
		<form method="POST" action="/ClassRoyale/home">
			<p>
				<label for="name">Nom de votre personnage :</label>
				<input type="text" name="name">
			</p>
			<p>
				<label for="hero-type">Quelle classe voulez-vous jouer ?</label>
				<select name="hero-type">
					<option value="archer">Archer</option>
					<option value="mage">Mage</option>
					<option value="guerrier">Guerrier</option>
				</select>
			</p>
			<p>
				<label for="enemy-type">Quel ennemi voulez-vous affronter ?</label>
				<select name="enemy-type">
					<option value="assassin">Assassin</option>
					<option value="necromantien">Nécromantien</option>
					<option value="berserker">Berserker</option>
				</select>
			</p>
			<p>
				<input type="submit" value="Go !">
			</p>
		</form>
	</body>
</html>
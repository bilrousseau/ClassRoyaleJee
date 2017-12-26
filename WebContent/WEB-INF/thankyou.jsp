<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param value="Merci !" name="title" />
	</jsp:include>
	<body>
		<h3>Merci d'avoir joué !</h3>
		<div class="game-sumup">
			<h4>Résultats des combats :</h4>
			<c:forEach var="game" items="${history}">
				<p class="game">
					<c:out value="${game}" />
				</p>
			</c:forEach>
		</div>
		<form method="POST">
			<input type="submit" name="goHome" value="Retour à l'accueil">
		
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param value="Fin de partie" name="title" />
	</jsp:include>
	<body>
		
		<div class="combat-info">
			<div class="hero-info">
				<p class="hero-name">
					<c:out value="${sessionScope.hero.nom}" />
				</p>
				<p class="hero-class">
					(<c:out value="${sessionScope.heroClass}" />)
				</p>
				<p class="hero-pv">
					<c:out value="${sessionScope.hero.pv}" /> PV
				</p>
				<p class="hero-pm">
					<c:out value="${sessionScope.hero.pm}" /> PM
				</p>
			</div>
			
			<div class="enemy-info">
				<p class="enemy-class">
					<c:out value="${sessionScope.enemyClass}" />
				</p>
				<p class="enemy-pv">
					<c:out value="${sessionScope.enemy.pv}" /> PV
				</p>
				<p class="enemy-pm">
					<c:out value="${sessionScope.enemy.pm}" /> PM
				</p>
			</div>
		</div>
		
		<div>
			<h3>Partie terminée</h3>
			<p class="combat-result">
				<c:choose>
					<c:when test="${sessionScope.gameWon}">
						<span class="game-won">Vous avez gagné !</span>
					</c:when>
					<c:otherwise>
						<span class="game-lost">Vous avez perdu...</span>
					</c:otherwise>
				</c:choose>
			</p>
			<p class="game-result">
				<c:out value="${gameResult}" />
			</p>
		</div>
		
		<div class="try-again">
			<form action="/ClassRoyale/home">
				<input type="submit" name="tryAgain" value="Recommencer">
			</form>
		</div>
	</body>
</html>
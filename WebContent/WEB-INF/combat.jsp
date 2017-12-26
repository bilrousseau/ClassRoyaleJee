<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param value="Combat" name="title" />
	</jsp:include>
	<body>
		<h3>Nouveau combat !</h3>
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
		
		<div class="combat-actions">
			<form action="/ClassRoyale/combat" method="POST">
				<p>
					<input type="submit" name="combatAction" value="PHY">
					<c:if test="${canSpe}">
						<input type="submit" name="combatAction" value="SPE">
					</c:if>
					<c:if test="${canUlt}">
						<input type="submit" name="combatAction" value="ULT">
					</c:if>
					<input type="submit" name="combatAction" value="Passer son tour">
				</p>
			</form>
		</div>
		
		<div class="hero-turn">
			<p>
				<c:out value="${heroAttack}" />
			</p>
		</div>
		<div class="enemy-turn">
			<p>
				<c:out value="${enemyAttack}" />
			</p>
		</div>
	</body>
</html>
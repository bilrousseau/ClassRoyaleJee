package com.parisjeux.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parisjeux.beans.*;

@WebServlet("/combat")
public class Combat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Combat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bon hero = (Bon) request.getSession().getAttribute("hero");
		
		request.setAttribute("canSpe", hero.isAtkSpePossible());
		request.setAttribute("canUlt", hero.isAtkUltPossible());
		this.getServletContext().getRequestDispatcher("/WEB-INF/combat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Bon hero = (Bon) session.getAttribute("hero");
		Mauvais enemy = (Mauvais) session.getAttribute("enemy");
		String attackChoice = (String) request.getParameter("combatAction");
		InfoJeu jeu = (InfoJeu) session.getAttribute("info");
		Integer choice = 0;
		
		if (attackChoice.equals("PHY") ) {
			choice = 1;
		} else if (attackChoice.equals("SPE") ) {
			choice = 2;
		} else if (attackChoice.equals("ULT") ) {
			choice = 3;
		}
		

		request.setAttribute("heroAttack", hero.attaquer(enemy, choice));
		jeu.setEnnemi(enemy);
		session.setAttribute("infoJeu", jeu);
		if (jeu.continuerCombat()) {
			request.setAttribute("enemyAttack", enemy.attaquer(choice, hero));
			jeu.setJoueur(hero);
			if (jeu.continuerCombat()) {
				session.setAttribute("hero", hero);
				session.setAttribute("enemy", enemy);
				session.setAttribute("infoJeu", jeu);
				doGet(request, response);
			} else {
				// L'IA gagne
				session.setAttribute("gameWon", false);
				response.sendRedirect("gameover");
				//this.getServletContext().getRequestDispatcher("/WEB-INF/gameover.jsp").forward(request, response);
			}
		} else {
			// Le joueur gagne
			session.setAttribute("gameWon", true);
			response.sendRedirect("gameover");
			//this.getServletContext().getRequestDispatcher("/WEB-INF/gameover.jsp").forward(request, response);
		}
	
		//this.getServletContext().getRequestDispatcher("/WEB-INF/combat.jsp").forward(request, response);
	}

}

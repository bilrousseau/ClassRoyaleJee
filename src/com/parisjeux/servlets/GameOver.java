package com.parisjeux.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisjeux.beans.InfoJeu;

@WebServlet("/gameover")
public class GameOver extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GameOver() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoJeu infoJeu = (InfoJeu) request.getSession().getAttribute("info");
		if (infoJeu.victoire()) {
			infoJeu.gagner();
		} else {
			infoJeu.perdre();
		}
		request.setAttribute("gameResult", infoJeu.getHistoriqueCombat().get(infoJeu.getHistoriqueCombat().size() - 1));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/gameover.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("tryAgain") != null) {
			response.sendRedirect("home");
		} else {
			doGet(request, response);
		}
	}

}

package com.parisjeux.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisjeux.beans.InfoJeu;
@WebServlet("/thankyou")
public class ThankYou extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThankYou() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoJeu infoJeu = (InfoJeu) request.getSession().getAttribute("info");
		
		request.setAttribute("history", infoJeu.getHistoriqueCombat());
		this.getServletContext().getRequestDispatcher("/WEB-INF/thankyou.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("home");
	}

}

package com.parisjeux.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parisjeux.beans.Archer;
import com.parisjeux.beans.Assassin;
import com.parisjeux.beans.Berserker;
import com.parisjeux.beans.Bon;
import com.parisjeux.beans.Guerrier;
import com.parisjeux.beans.InfoJeu;
import com.parisjeux.beans.Mage;
import com.parisjeux.beans.Mauvais;
import com.parisjeux.beans.Necromantien;
import com.parisjeux.beans.Personnage;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		String heroType = request.getParameter("hero-type");
		String enemyType = request.getParameter("enemy-type");
		String name = request.getParameter("name");
		Bon hero = null;
		Mauvais enemy = null;
		
		if (heroType.equals("archer")) {
			System.out.println("Archer selected");
			hero = new Archer();
		} else if (heroType.equals("mage")) {
			System.out.println("Mage selected");
			hero = new Mage();
		} else if (heroType.equals("guerrier")) {
			System.out.println("Guerrier selected");
			hero = new Guerrier();
		}
		hero.setNom(name);
		
		if (enemyType.equals("assassin")) {
			enemy = new Assassin();
		} else if (enemyType.equals("necromantien")) {
			enemy = new Necromantien();
		} else if (enemyType.equals("berserker")) {
			enemy = new Berserker();
		}
		
		session.setAttribute("hero", hero);
		session.setAttribute("enemy", enemy);
		session.setAttribute("info", new InfoJeu(hero, enemy));
		session.setAttribute("heroClass", hero.getClass().getSimpleName());
		session.setAttribute("enemyClass", enemy.getClass().getSimpleName());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/combat.jsp").forward(request, response);
	}

}

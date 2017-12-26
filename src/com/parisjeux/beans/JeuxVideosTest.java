package com.parisjeux.beans;

import java.util.Scanner;

public class JeuxVideosTest {

	public static void main(String[] args) {

		System.out.println("Début du combat");
		Bon joueur = PersonnageSelection.personnageSelection();
		joueur.demandeEtValidationDuNom();
		System.out.println(joueur);
		MauvaisSelection mechant = new MauvaisSelection();
		Mauvais vraiMechant = mechant.mauvaisSelection();
		System.out.println(vraiMechant);
		InfoJeu jeu = new InfoJeu();
		jeu.setJoueur(joueur);
		jeu.setEnnemi(vraiMechant);
		Combat.combatAMort(joueur, vraiMechant);
		jeu.resultat();
		// Mais non

		
	}

}

package com.parisjeux.beans;

import java.util.Scanner;

public class Bon extends Personnage {

	public Bon() {
		// TODO Auto-generated constructor stub
	}


	/** Propose au joueur de choisir une attaque
	 *  (affichage console)
	 *
	 * @return void
	 */
	public void ProposerAtk() {
		System.out.println("Attaques disponibles: (Entrez la valeur correspondante)");
		System.out.println("\t0 : Passer un tour");
		System.out.println("\t1 : Attaque normale");
		if (isAtkSpePossible()) {
			System.out.println("\t2 : Attaque spéciale");
		}
		if (isAtkUltPossible()) {
			System.out.println("\t3 : Attaque ultime");
		}

	}

	/**
	 *
	 *
	 * @return Integer numAtk Identifiant de l'attaque
	 */
	public Integer joueurSelectionneAtk() {
		Scanner sc = new Scanner(System.in);
		String tmp;
		Integer numAtk = -1;
		while (numAtk == -1) {
			tmp = sc.next();
			try {
				numAtk = Integer.parseInt(tmp);

			} catch (Exception e) {
				// Le joueur entre autre chose qu'un nombre
				numAtk = -1;
			}

			// Le joueur entre un nombre invalide
			if (numAtk < 0 || numAtk > 3) {
				numAtk = -1;
			}

			// Le joueur essaie de tricher
			if ( numAtk == 2 && (!this.isAtkSpePossible())) {
				numAtk = -1;
			}

			// Le joueur essaie de tricher
			if  (numAtk == 3 && (!isAtkUltPossible())) {
				numAtk = -1;
			}
			// Affichage du message d'erreur
			if (numAtk == -1) {
				System.err.println("Attaque invalide");
			}

		}
		
		return numAtk;
	}

	public void demandeEtValidationDuNom () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donnez un nom à votre personnage: ");
		String nom = sc.nextLine();
		System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
		String choix = sc.nextLine();
		while (!choix.toLowerCase().equals("o")) {
			System.out.println("Donnez un nom à votre personnage: ");
			nom = sc.nextLine();
			System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
			choix = sc.nextLine();
		}

		System.out.println("Votre personnage s'appelle " + nom);

		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Caractéristique de votre Hero: nom=" + nom + ", pv=" + pv + ", pm=" + pm + ", phy=" + phy + ", spe=" + spe + ", ult=" + ult
				+ ", vol=" + vol ;
	}
}

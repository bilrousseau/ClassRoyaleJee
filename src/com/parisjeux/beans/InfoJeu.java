package com.parisjeux.beans;

import java.util.ArrayList;

public class InfoJeu {
	private Bon joueur;
	private Mauvais ennemi;
	private static Integer nbVictoires = 0;
	private static Integer nbParties = 0;
	private static ArrayList<String> historiqueCombat = new ArrayList<String>();

	public InfoJeu() {
		super();
	}

	public InfoJeu(Bon joueur, Mauvais ennemi) {
		this.joueur = joueur;
		this.ennemi = ennemi;
		nbParties = 0;
		nbVictoires = 0;
		historiqueCombat = new ArrayList<String>();
	}

	public Boolean continuerCombat() {
		return (this.ennemi.getPv() > 0 && this.joueur.getPv() > 0);
	}

	public void gagner() {
		nbVictoires++;
		nbParties++;
		this.ajouterDansHistorique();
	}

	public Boolean victoire() {
		return (this.getJoueur().getPv() > 0 && this.getEnnemi().getPv() <= 0);
	}

	public void perdre() {
		nbVictoires--;
		nbParties++;
		this.ajouterDansHistorique();
	}

	public Boolean defaite() {
		return (this.getJoueur().getPv() <= 0 && this.getEnnemi().getPv() > 0);
	}

	public void ajouterDansHistorique() {
		Personnage gagnant = (this.ennemi.getPv() > 0) ? this.getEnnemi() : this.getJoueur();
		Personnage perdant = (this.ennemi.getPv() > 0) ? this.getJoueur() : this.getEnnemi();

		String combat = gagnant.getNom() + "(" + gagnant.getClass().getSimpleName() + ") a vaincu " + perdant.getNom()
				+ "(" + perdant.getClass().getSimpleName() + ") avec " + gagnant.getPv() + " PV �la fin du combat";
		historiqueCombat.add(combat);
	}

	public void effacerDansHistorique(String combat) {
		historiqueCombat.remove(combat);
	}

	public void afficherHistorique() {
		System.out.println("\n\nHistorique du combat :");
		this.getHistoriqueCombat().forEach(combat -> System.out.println(combat));
	}

	public void afficherStats() {

		System.out.println("Partie terminée");
		System.out.println("Nombre de victoires : " + this.getNbVictoires());
		System.out.println("Nombre de défaites : " + (this.getNbParties() - this.getNbVictoires()));
	}

	public Bon getJoueur() {
		return joueur;
	}

	public void setJoueur(Bon joueur) {
		this.joueur = joueur;
	}

	public Mauvais getEnnemi() {
		return ennemi;
	}

	public void setEnnemi(Mauvais ennemi) {
		this.ennemi = ennemi;
	}

	public Integer getNbVictoires() {
		return nbVictoires;
	}

	public void setNbVictoires(Integer nbVic) {
		nbVictoires = nbVic;
	}

	public Integer getNbParties() {
		return nbParties;
	}

	public void setNbParties(Integer nb) {
		nbParties = nb;
	}

	public ArrayList<String> getHistoriqueCombat() {
		return historiqueCombat;
	}

	public void setHistoriqueCombat(ArrayList<String> historique) {
		historiqueCombat = historique;
	}

	@Override
	public String toString() {
		return "InfoJeu [joueur=" + joueur.toString() + ", ennemi=" + ennemi.toString() + "]";
	}

	
}

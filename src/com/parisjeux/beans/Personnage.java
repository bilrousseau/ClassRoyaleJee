package com.parisjeux.beans;

import java.util.Scanner;

// CHOIX ATTAQUES ET PASSER TOUR

abstract public class Personnage {
    protected String nom;
    protected Integer pv; // Point de vie
    protected Integer pm; // Point de magie
    protected Integer phy; // Puissance d'attaque de base
    protected Integer spe; // Puissance de l'attaque 50%
    protected Integer ult; // Puissance de l'attaque ultime
    protected Integer vol; // VolontÃ©: vitesse de remplissage de la barre de magie


    //Attaque physique. Prend le personnage ï¿½ attaquer en entrï¿½e. Les dï¿½gats sont calculï¿½s alï¿½atoirement.
    //Set les PV du personnage diminuï¿½.
    //Augmente les PM du personnage selon sa volontï¿½.
    protected String atkPhy(Personnage p) {
    	Double damage = this.phy * Math.random() * 2;
    	
        p.setPv(p.getPv() - damage);
        setPm(getPm() + getVol());
        return this.getNom() + " lance PHY sur " +p.getNom() + ", faisant "+ damage.intValue() + " de dégât.";
    }

    //Attaque spï¿½. Prend le personnage ï¿½ attaquer en entrï¿½e. Les dï¿½gats sont calculï¿½s alï¿½atoirement.
    //Set les PV du personnage diminuï¿½.
    //Diminue les points de magie de 50.
    protected String atkSpe(Personnage p) {
    	Double damage = (this.spe * Math.random() * 2) + this.phy;
        p.setPv(p.getPv() - damage);
        setPm(getPm() - 50);
        
        return this.getNom() + " lance SPE sur " +p.getNom() + ", faisant "+ damage.intValue() + " de dégât.";

    }

    //Attaque ult. Prend un personnage ï¿½ attaquer en entrï¿½e. Les dï¿½gats sont calculï¿½s alï¿½atoirement.
    //Set les PV du personnage diminuï¿½.
    //Set la jauge de magie ï¿½ 0.
    protected String atkUlt(Personnage p) {
    	Double damage = (this.ult * Math.random() * 2) + this.phy + this.spe;
    	
        p.setPv(p.getPv() - damage);
        setPm(0);
        return this.getNom() + " lance ULT sur " +p.getNom() + ", faisant "+ damage.intValue() + " de dégât.";

    }


    //Surcharge de setPv pour que le calcul des dï¿½gats avec le rand
    public void setPv(Double pv) {
        this.pv = pv.intValue();
    }


    public Integer getSpe() {
        return spe;
    }

    public void setSpe(Integer spe) {
        this.spe = spe;
    }

    public Integer getUlt() {
        return ult;
    }

    public void setUlt(Integer ult) {
        this.ult = ult;
    }

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }

    public Integer getPhy() {
        return phy;
    }

    public void setPhy(Integer phy) {
        this.phy = phy;
    }

    // MÃ©thode PASSER TOUR
    public String passerTour() {
        this.pm += (vol * 2);
        if (this.pm > 100)
            this.pm = 100;
        return this.getNom() + " se concentre...";
    }


    /**
     * Teste si on dispose de suffisamment de PM pour
     * l'attaque speciale
     * Ã  deplacer dans Personnage
     *
     * @return Boolean
     */
    public Boolean isAtkSpePossible() {
        if (this.pm >= 50) {
            return true;
        }
        return false;
    }

    /**
     * Teste si on dispose de suffisamment de PM pour
     * l'attaque ultime
     * Ã  deplacer dans Personnage
     *
     * @return Boolean
     */
    public Boolean isAtkUltPossible() {
        if (this.pm >= 100) {
            return true;
        }
        return false;
    }


    /**
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
            if (numAtk == 2 && (!this.isAtkSpePossible())) {
                numAtk = -1;
            }

            // Le joueur essaie de tricher
            if (numAtk == 3 && (!isAtkUltPossible())) {
                numAtk = -1;
            }
            // Affichage du message d'erreur
            if (numAtk == -1) {
                System.err.println("Attaque invalide");
            }

        }
   
        return numAtk;
    }

    // Effectue l'action -> attaque ou passer tour
    public String attaquer(Personnage p, Integer choix) {
        if (choix == 0) {
            return this.passerTour();
        } else if (choix == 1) {
        	return this.atkPhy(p);
        } else if (choix == 2) {
            return this.atkSpe(p);
        } else if (choix == 3) {
            return this.atkUlt(p);
        }
        return null;
    }

    public void demandeEtValidationDuNom() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez un nom Ã  votre personnage: ");
        String nom = sc.nextLine();
        System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
        String choix = sc.nextLine();
        while (choix.toLowerCase().equals("n")) {
            System.out.println("Donnez un nom Ã  votre personnage: ");
            nom = sc.nextLine();
            System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
            choix = sc.nextLine();
        }
        System.out.println("Votre personnage s'appelle " + nom);
        this.nom = nom;

    }
}

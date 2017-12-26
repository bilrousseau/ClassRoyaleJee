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
    protected Integer vol; // Volonté: vitesse de remplissage de la barre de magie


    //Attaque physique. Prend le personnage � attaquer en entr�e. Les d�gats sont calcul�s al�atoirement.
    //Set les PV du personnage diminu�.
    //Augmente les PM du personnage selon sa volont�.
    protected void atkPhy(Personnage p) {
        p.setPv(p.getPv() - (this.phy * Math.random()) * 2);
        setPm(getPm() + getVol());
    }

    //Attaque sp�. Prend le personnage � attaquer en entr�e. Les d�gats sont calcul�s al�atoirement.
    //Set les PV du personnage diminu�.
    //Diminue les points de magie de 50.
    protected void atkSpe(Personnage p) {
        p.setPv(p.getPv() - ((this.spe * Math.random() * 2) + this.phy));
        setPm(getPm() - 50);
    }

    //Attaque ult. Prend un personnage � attaquer en entr�e. Les d�gats sont calcul�s al�atoirement.
    //Set les PV du personnage diminu�.
    //Set la jauge de magie � 0.
    protected void atkUlt(Personnage p) {
        p.setPv(p.getPv() - ((this.ult * Math.random() * 2) + this.phy + this.spe));
        setPm(0);
    }


    //Surcharge de setPv pour que le calcul des d�gats avec le rand
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

    // Méthode PASSER TOUR
    void passerTour() {
        this.pm += (vol * 2);
        if (this.pm > 100)
            this.pm = 100;
    }


    /**
     * Teste si on dispose de suffisamment de PM pour
     * l'attaque speciale
     * à deplacer dans Personnage
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
     * à deplacer dans Personnage
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
    public void attaquer(Personnage p, Integer choix) {
        if (choix == 0) {
            this.passerTour();
        } else if (choix == 1) {
            this.atkPhy(p);
        } else if (choix == 2) {
            this.atkSpe(p);
        } else if (choix == 3) {
            this.atkUlt(p);
        }
    }

    public void demandeEtValidationDuNom() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Donnez un nom à votre personnage: ");
        String nom = sc.nextLine();
        System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
        String choix = sc.nextLine();
        while (choix.toLowerCase().equals("n")) {
            System.out.println("Donnez un nom à votre personnage: ");
            nom = sc.nextLine();
            System.out.println("Vous avez saisi : " + nom + ", Voulez-vous confirmer?(O=oui/N=non)");
            choix = sc.nextLine();
        }
        System.out.println("Votre personnage s'appelle " + nom);
        this.nom = nom;

    }
}

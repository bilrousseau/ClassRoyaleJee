package com.parisjeux.beans;

import java.util.Scanner;

public class InfoJeuTest {
    public static void main(String[]  args) {

        Boolean recommencer = true;
        Scanner sc = new Scanner(System.in);
        String recommencerChoix = new String();
        InfoJeu jeu = null;

        while (recommencer) {
            // recommencer
            Personnage archer = new Archer();
            archer.setNom("Legolas");

            Personnage necro = new Necromantien();
            necro.setNom("Ashley");

            /**
             *  On enregistre les informations de jeu. Nécessaire pour compter les victoires / savoir quand le jeu se termine
             */
            jeu = new InfoJeu();
            jeu.setJoueur(archer);
            jeu.setEnnemi(necro);

            /**
             * On continue tant que les deux personnages ont des PV
             */
            while (jeu.continuerCombat()) {
                // TODO: Mettre ici le vrai déroulement du combat
                System.out.println("L'ennemi a "+necro.getPv() + " PV");
                archer.atkPhy(necro);
                System.out.println(jeu.continuerCombat());
            }
            if (jeu.victoire()) {
                jeu.gagner();
            } else {
                jeu.perdre();
            }

            /**
             *  On demande à l'utilisateur s'il veut recommencer un combat
             */
            System.out.println("Voulez-vous recommencer ? o/n");
            recommencerChoix = sc.nextLine().toLowerCase();
            while (!recommencerChoix.equalsIgnoreCase("n") && !recommencerChoix.equalsIgnoreCase("o")) {
                System.out.println("Voulez-vous recommencer ? o/n");
                recommencerChoix = sc.nextLine().toLowerCase();
            }
            recommencer = (recommencerChoix.equals("o"));
        }
        
        jeu.afficherStats();
        jeu.afficherHistorique();
    }
    
    
}

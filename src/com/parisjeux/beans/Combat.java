package com.parisjeux.beans;

public class Combat {


    static void combatAMort( Bon bon, Mauvais mauvais ){
        // Le bon attaque avant le mauvais
        while( true ){
        	 System.out.println(bon);
        	 System.out.println(mauvais);
            bon.ProposerAtk();
            Integer choix = bon.joueurSelectionneAtk();
            bon.attaquer(mauvais, choix);
            // on arrête le combat avant que le mechant attaque si on a gagne
            if( mauvais.getPv() <= 0 ) {
                break;
               
            }
            mauvais.attaquer(0, bon); // choix est inutile ici
            // on arrete le combat si on a perdu
            if( bon.getPv() <= 0  ) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        Bon bon = new Bon();
        Mauvais mauvais = new Mauvais();
        combatAMort(bon, mauvais);

    }

}

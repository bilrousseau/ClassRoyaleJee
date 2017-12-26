package com.parisjeux.beans;

import java.util.Scanner;

public class MauvaisSelection {
    public Mauvais mauvaisSelection() {
        //Alloooo

        System.out.println("Veuillez selectionner votre ennemie !");
        System.out.println("Veuillez choisir votre Ennemi : 1) Assassin, 2) Necromancien, 3) Berserker; puis Entrer.");
        Mauvais mauvais = new Mauvais();
        Scanner scanner = new Scanner(System.in);
        Integer test = 0;
//Rentre dans le while pour éviter les bug venant d'une mauvaise séléction de l'utilisateur
        
        while (test == 0) {

            try {
                Integer perso = Integer.parseInt(scanner.next());
                if (perso == 1) {
                    //importation de l'objet Archere qui hérite de personnage
                    mauvais = new Assassin();
                    test = 1;

                    System.out.println("Vous allez affronter l'Assassin, attention derriere vous!");



                } else if (perso == 2) {

                    //importation de l'objet mage qui hérite de personnage
                    mauvais = new Necromantien();
                    test = 1;




                    System.out.println("Vous avez choisie le Necromancien! Les morts se relèvent!");



                }

                else if (perso == 3) {
                    //importation de l'objet guerrier qui hérite de personnage
                    mauvais = new Berserker();
                    test = 1;

                    System.out.println("Vous avez choisie le Berserker! Gare à ça hache! ");


                } else {

                    System.out.println("Veuillez choisir entre '1', '2' ou '3'.");
                }
            } catch (Exception e) {
                System.out.println("Veuillez choisir entre '1', '2' ou '3'.");
            }
            
        }
        return mauvais;
        

    }
}

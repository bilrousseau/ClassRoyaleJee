package com.parisjeux.beans;

public class Mauvais extends Personnage {

    public Mauvais() {
        super();
    }

    // Je rajoute le paramètre choix car il est demandé dans la fonction Personnage.attaquer()

    public String attaquer(Integer choix, Personnage p) {
        /**
         *  Le nécromancien a une chance sur 3 de passer son tour pour engranger de la magie.
         *  Les autres, une chance sur 10.
         */
        // Ici je cherche à déterminer si l'instance courante est de type Necromantien.
        // TODO: utiliser instanceof pour être plus scalable
        if (this.getPm() < 100) {
        	Boolean skipTurn = (this.phy == 22 && this.vol == 15) ? this.randomizeAttack(33) : this.randomizeAttack(10);

            if (skipTurn) {
                return this.passerTour();
            }
        }
        
        /**
         * A 50 pm ou moins, le m�chant lance toujours une attaque PHY.
         */
        if (!this.isAtkSpePossible() && !this.isAtkUltPossible()) {
            return this.atkPhy(p);
        } 
        /**
         * Entre 50 et 74 pm, le m�chant a 20% de chances de lancer une attaque SPE.
         */
        else if (this.isAtkSpePossible() && this.getPm() < 75) {
            if (this.randomizeAttack(20)) {
                return this.atkSpe(p);
            } else {
                return this.atkPhy(p);
            }
        }
        /**
         * Entre 75 et 99 pm, le m�chant a 40% de chances de lancer une attaque SPE.
         */
        else if (this.isAtkSpePossible() && this.getPm() < 100) {
            if (this.randomizeAttack(40)) {
                return this.atkSpe(p);
            } else {
                return this.atkPhy(p);
            }
        }
        /**
         * A 100 pm, le m�chant a 20% de chances de lancer une attaque SPE, et 80% de lancer une attaque ULT.
         */
        else {
            this.setPm(100);
            if (this.randomizeAttack(20)) {
                return this.atkSpe(p);
            } else {
                return this.atkUlt(p);
            }
        }
        //this.setPm(this.getPm()+ this.getVol());
    }

    private Boolean randomizeAttack(Integer percent) {
        Double random = Math.random() * 100 + 1;
        Integer randomInt = random.intValue();
        return (randomInt < percent);
    }

    @Override
    public String toString() {
        return "Caractéristique de votre adversaire: nom=" + nom + ", pv=" + pv + ", pm=" + pm + ", phy=" + phy + ", spe=" + spe + ", ult=" + ult
                + ", vol=" + vol;
    }
}

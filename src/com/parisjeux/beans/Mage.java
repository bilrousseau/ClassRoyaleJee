package com.parisjeux.beans;

import java.util.concurrent.ThreadLocalRandom;

public class Mage extends Bon {
	
	public Mage (){
		super();
		this.setNom("Mage");
		this.pv = ThreadLocalRandom.current().nextInt( 400 , 500 + 1 ); 
		this.pm = 100;
		this.phy = 22;
		this.spe = ThreadLocalRandom.current().nextInt( 70, 110 + 1 );
		this.ult = ThreadLocalRandom.current().nextInt( 150 , 200 + 1 );
		this.vol = 15;
		
	}
}

package com.parisjeux.beans;

import java.util.concurrent.ThreadLocalRandom;

public class Necromantien extends Mauvais {
	
	public Necromantien (){
		super();
		this.setNom("Death Notes");
		this.pv = ThreadLocalRandom.current().nextInt( 400 , 500 + 1 ); 
		this.pm = 0;
		this.phy = 3;
		this.spe = ThreadLocalRandom.current().nextInt( 70, 110 + 1 );
		this.ult = ThreadLocalRandom.current().nextInt( 150 , 200 + 1 );
		this.vol = 15;
		
	}
}

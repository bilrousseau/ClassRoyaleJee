package com.parisjeux.beans;

import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Bon{

	
	public Archer (){
		super();
		this.setNom("Archette");
		this.pv = ThreadLocalRandom.current().nextInt( 400 , 500 + 1 );
		this.pm = 0;
		this.phy = 17;
		this.spe = ThreadLocalRandom.current().nextInt( 30, 45 + 1 );
		this.ult = ThreadLocalRandom.current().nextInt( 70 , 100 + 1 );
		this.vol = 15;
	
	}
}

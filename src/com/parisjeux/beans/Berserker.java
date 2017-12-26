package com.parisjeux.beans;

import java.util.concurrent.ThreadLocalRandom;

public class Berserker extends Mauvais {

	public Berserker() {
		super();
		this.setNom("BerserKKKKK");
		this.pv = ThreadLocalRandom.current().nextInt(700, 750 + 1);
		this.pm = 0;
		this.phy = 22;
		this.spe = ThreadLocalRandom.current().nextInt(20, 40 + 1);
		this.ult = ThreadLocalRandom.current().nextInt(30, 60 + 1);
		this.vol = 5;
	}
}
package com.parisjeux.beans;

abstract public class Attack {
	private Integer damage;
	private String name;
	private AttackType type;
	
	public Attack() {
		super();
	}
	
	public Attack(Integer damage, String name, AttackType type) {
		super();
		this.damage = damage;
		this.name = name;
		this.type = type;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttackType getType() {
		return type;
	}

	public void setType(AttackType type) {
		this.type = type;
	}
	
	
	
}

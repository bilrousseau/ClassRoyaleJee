package com.parisjeux.beans;

public enum AttackType {
	PHY("Physical"),
	SPE("Special"),
	ULT("Ultimate");
	
	private String type;
	
	AttackType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

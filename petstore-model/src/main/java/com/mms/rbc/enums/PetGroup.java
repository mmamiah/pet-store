package com.mms.rbc.enums;

/**
 * PetGroup
 */
public enum PetGroup {
	
	DOMESTICATED("DOMESTICATED", "DOMESTICATED"),
	WILD_ANIMAL("WILD_ANIMAL", "WILD ANIMAL");
	
	private String code;
	private String name;

	PetGroup(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}

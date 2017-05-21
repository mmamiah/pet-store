package com.mms.rbc.model.pet;

import com.mms.rbc.enums.PetGroup;
import com.mms.rbc.enums.PetType;
import com.mms.rbc.enums.PetUsage;

/**
 * Pet
 */
public class Pet {
	
	private long id;
	private String name;
	private String description;
	
	private PetUsage usage;
	private PetGroup group;
	private PetType type;
	
	private int length;
	private int weight;
	private String color;

	public Pet() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PetUsage getUsage() {
		return usage;
	}

	public void setUsage(PetUsage usage) {
		this.usage = usage;
	}

	public PetGroup getGroup() {
		return group;
	}

	public void setGroup(PetGroup group) {
		this.group = group;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

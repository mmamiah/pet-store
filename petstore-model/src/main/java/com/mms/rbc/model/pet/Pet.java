package com.mms.rbc.model.pet;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.mms.rbc.commons.PetStoreKeys;
import com.mms.rbc.enums.PetGroup;
import com.mms.rbc.enums.PetType;
import com.mms.rbc.enums.PetUsage;

/**
 * Pet
 */
@Entity
public class Pet {

	@Id 
	@GeneratedValue
	private long id;
	private String name;
	private String description;

	@Enumerated(EnumType.STRING)
	private PetUsage usage;
	
	@Enumerated(EnumType.STRING)
	private PetGroup petGroup;
	
	@Enumerated(EnumType.STRING)
	private PetType petType;
	
	private long length;
	private long weight;
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

	public PetGroup getPetGroup() {
		return petGroup;
	}

	public void setPetGroup(PetGroup group) {
		this.petGroup = group;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType type) {
		this.petType = type;
	}

	public long getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getWeight() {
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

	@Override
	public String toString() {
		StringBuilder userToString = new StringBuilder(PetStoreKeys.OPEN_BRACKET).append(id).append(PetStoreKeys.CLOSE_BRACKET)
				.append(PetStoreKeys.SPACE).append(name).append(PetStoreKeys.COLON)
				.append(PetStoreKeys.SPACE).append(petGroup)
				.append(PetStoreKeys.COMMA).append(usage)
				.append(PetStoreKeys.COMMA).append(petType);
		return userToString.toString();
	}
}

package com.mms.rbc.model.user;

import com.mms.rbc.enums.UserType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User
 */
@Entity
public class PetStoreUser {
	
	@Id @GeneratedValue
	private long id;
	private String surname;
	private String name;
	private String email;
	private UserType type;

//	@JsonIgnore
	public String password;
	private String username;

	public PetStoreUser() {
	}

	public PetStoreUser(UserType type, String username) {
		this.type = type;
		this.username = username;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

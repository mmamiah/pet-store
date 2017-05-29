package com.mms.rbc.model.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mms.rbc.commons.PetStoreKeys;
import com.mms.rbc.enums.UserRole;

/**
 * User
 */
@Entity
public class StoreUser  {
	
	@Id 
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@JsonIgnore
	public String password;
	
	private String userName;

	public StoreUser() {
	}

	public StoreUser(UserRole userRole, String userName) {
		this.userRole = userRole;
		this.userName = userName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String surname) {
		this.firstName = surname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder userToString = new StringBuilder(PetStoreKeys.OPEN_BRACKET).append(id).append(PetStoreKeys.CLOSE_BRACKET)
				.append(PetStoreKeys.SPACE).append(userName).append(":")
				.append(PetStoreKeys.SPACE).append(firstName).append(PetStoreKeys.SPACE).append(lastName);
		return userToString.toString();
	}
}

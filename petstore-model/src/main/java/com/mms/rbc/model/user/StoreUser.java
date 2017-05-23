package com.mms.rbc.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.mms.rbc.enums.UserType;
import org.hibernate.annotations.Type;

/**
 * User
 */
@Entity
public class StoreUser  {
	
	@Id @GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;

//	@JsonIgnore
	public String password;
	private String userName;

	public StoreUser() {
	}

	public StoreUser(UserType userType, String userName) {
		this.userType = userType;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

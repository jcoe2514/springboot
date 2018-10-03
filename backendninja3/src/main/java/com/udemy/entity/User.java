package com.udemy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tc_user")
public class User {

	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 45)
	private String userName;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enable", nullable = false)
	private boolean enable;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private Set<UserRoles> userRoles = new HashSet<UserRoles>();
     
	

	public User(String userName, String password, boolean enable) {
		super();
		this.userName = userName;
		this.password = password;
		this.enable = enable;
	}



	public User(String userName, String password, boolean enable, Set<UserRoles> userRoles) {
		super();
		this.userName = userName;
		this.password = password;
		this.enable = enable;
		this.userRoles = userRoles;
	}



	public User() {

	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

}

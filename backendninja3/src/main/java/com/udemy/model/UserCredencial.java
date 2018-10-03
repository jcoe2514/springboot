package com.udemy.model;

public class UserCredencial {
	
	private String userName;
	private String password;
	
	@Override
	public String toString() {
		return "UserCredencial [userName=" + userName + ", password=" + password + "]";
	}


	public UserCredencial() {}
	
	
	public UserCredencial(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	
	

}

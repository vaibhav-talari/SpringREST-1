package com.example.model;

import javax.validation.constraints.Pattern;


public class Login {
	
	@Pattern(regexp="^[a-zA-Z]+$")
	private String userName;
	
	private String password;
	
	public Login()
	{
	}
	
	public Login(String userName, String password)
	{
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

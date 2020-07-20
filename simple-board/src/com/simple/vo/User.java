package com.simple.vo;

import java.sql.Date;

public class User {

	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userDisabled;
	private Date userCreateDate;
	
	public User() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDisabled() {
		return userDisabled;
	}

	public void setUserDisabled(String userDisabled) {
		this.userDisabled = userDisabled;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	
	
}

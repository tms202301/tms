package com.tms.commons.login.beans;

public class RequestLogin {
	
	private String userName;
	private String userSec;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSec() {
		return userSec;
	}
	public void setUserSec(String userSec) {
		this.userSec = userSec;
	}
	
	@Override
	public String toString() {
		return "RequestLogin [userName=" + userName + ", userSec=" + userSec + "]";
	}
	
	
}

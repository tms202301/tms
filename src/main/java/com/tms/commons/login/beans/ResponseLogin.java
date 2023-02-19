package com.tms.commons.login.beans;

import com.mysql.cj.jdbc.util.BaseBugReport;
import com.tms.commons.beans.BaseResponse;

public class ResponseLogin extends BaseResponse {
	
	private String firstName;
	private String lastName;
	private String userName;
	private Long mobileNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
}

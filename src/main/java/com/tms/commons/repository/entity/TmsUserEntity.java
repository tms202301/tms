package com.tms.commons.repository.entity;

import com.tms.commons.repository.BaseEntity;

import com.tms.commons.repository.listner.TmsUserListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.PostPersist;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "TMS_USER")
@EntityListeners(TmsUserListener.class)
public class TmsUserEntity extends BaseEntity {

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "DOB")
	private Long dateOfBirth;
	
	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;
	
	@Column(name = "PAN_NUMBER")
	private String panNumber;
	@Column(name = "USER_TYPE")
	private String userType;

}

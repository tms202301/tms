package com.tms.commons.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TmsUserInfo {

	private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long dateOfBirth;
    private Long mobileNumber;
    private String panNumber;
	private String userType;
    private Long recordId;
}

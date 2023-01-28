package com.tms.commons.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tms.commons.login.beans.RequestLogin;
import com.tms.commons.login.beans.ResponseLogin;
import com.tms.commons.repository.TmsUserRepository;
import com.tms.commons.repository.entity.TmsUserEntity;

@Component
public class LoginService {
	
	@Autowired
	private TmsUserRepository tmsUserRepository;
	
	public ResponseLogin login(@RequestBody RequestLogin request) {
		System.out.println("User Name =>>>>>>>>>>>>"+request.getUserName());
		TmsUserEntity userEntity = tmsUserRepository.findByUserName(request.getUserName());
		ResponseLogin response = new ResponseLogin();
		response.setUserName(userEntity.getUserName());
		response.setFirstName(userEntity.getFirstName());
		response.setLastName(userEntity.getLastName());
		response.setMobileNumber(userEntity.getMobileNumber());
		System.out.println(request.getUserSec()+"<<<<<<<<<< Password >>>>>>>>"+userEntity.getPassword());
		return response;
	}

}

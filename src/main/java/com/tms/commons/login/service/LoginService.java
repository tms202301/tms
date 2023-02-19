package com.tms.commons.login.service;

import com.tms.commons.utils.TmsCodes;
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
		ResponseLogin response = new ResponseLogin();
		if(null != request.getUserName() && null != request.getUserSec()
				&&  !request.getUserName().isEmpty() && !request.getUserSec().isEmpty()) {
			TmsUserEntity userEntity = tmsUserRepository.findByUserName(request.getUserName());
			if(request.getUserName().equalsIgnoreCase(userEntity.getUserName()) &&
				request.getUserSec().equalsIgnoreCase(userEntity.getPassword())) {
				response.setUserName(userEntity.getUserName());
				response.setFirstName(null != userEntity.getFirstName() ? userEntity.getFirstName() : "");
				response.setLastName(null != userEntity.getLastName() ? userEntity.getLastName() : "");
				response.setMobileNumber(userEntity.getMobileNumber());
				response.setStatus(TmsCodes.SUCCESS.name());
				response.setMessageCode("1002");
				response.setMessage("Login successful");
			} else {
				response.setStatus(TmsCodes.FAIL.name());
				response.setMessageCode("1001");
				response.setMessage("Invalid user name or password");
			}
		} else {
			response.setStatus(TmsCodes.FAIL.name());
			response.setMessageCode("1000");
			response.setMessage("Invalid input, please enter user name and password");
		}
		return response;
	}

}

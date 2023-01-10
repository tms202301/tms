package com.tms.commons.login.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.commons.login.beans.RequestLogin;
import com.tms.commons.login.beans.ResponseLogin;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@PostMapping(path = "/login")
	public ResponseLogin login(@RequestBody RequestLogin request) {
		ResponseLogin response = new ResponseLogin();
		response.setUserName(request.getUserName());
		response.setFirstName("Sreenivasulu");
		response.setLastName("Reddy");
		return response;
	}
}

package com.tms.commons.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.commons.login.beans.RequestLogin;
import com.tms.commons.login.beans.ResponseLogin;
import com.tms.commons.login.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping(path = "/login")
	public ResponseLogin login(@RequestBody RequestLogin request) {
		return service.login(request);
	}
}

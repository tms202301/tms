package com.tms.commons.login.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.commons.login.beans.RequestLogin;
import com.tms.commons.login.beans.ResponseLogin;
import com.tms.commons.login.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Login Management Endpoints")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping(path = "/login")
	@Operation(summary = "Login")
	public ResponseEntity<?> login(@RequestBody RequestLogin request) {
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(service.login(request));
	}
}

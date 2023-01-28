package com.tms.commons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.commons.beans.TmsUserInfo;
import com.tms.commons.services.TmsUserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/user")
public class TmsUserController {
	
	@Autowired
	private TmsUserService tmsUserService;
	
	@PostMapping(path = "/add")
	public List<TmsUserInfo> addUser(@RequestBody TmsUserInfo request) {
		System.out.println("Request =>>>>>>>>>>>>>>>>>>>>>>>>>>"+request);
		return tmsUserService.addUser(request);
	}
	
	@PostMapping(path = "/list")
	public List<TmsUserInfo> userList(@RequestBody TmsUserInfo request) {
		return tmsUserService.list(request);
	}

}

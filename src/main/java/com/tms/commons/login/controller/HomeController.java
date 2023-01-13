package com.tms.commons.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {
	
	@RequestMapping(value = "/") 
	public String index() {
		return "index";
	}
}

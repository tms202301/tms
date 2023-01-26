package com.tms.commons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tms.commons.beans.StateInfo;
import com.tms.commons.services.StateServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/states")
public class StateController {

	@Autowired
	private StateServices service;

	@GetMapping(path = "/list")	
	public List<StateInfo> list() {
		return service.findAllStates();
	}
	
}

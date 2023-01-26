package com.tms.commons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tms.commons.beans.DistrictInfo;
import com.tms.commons.services.DistrictServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/districts")
public class DistrictController {
	@Autowired
	private DistrictServices service;

	@GetMapping(path = "/list")	
	public List<DistrictInfo> list(@RequestParam Long recordId) {
		return service.findDistrictByStates(recordId);
	}
}

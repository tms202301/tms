package com.tms.commons.controller;

import java.util.List;

import com.tms.commons.utils.TmsCodes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tms.commons.beans.TmsUserInfo;
import com.tms.commons.services.TmsUserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/user")
@Tag(name = "User Management Endpoints")
public class TmsUserController {
	
	@Autowired
	private TmsUserService tmsUserService;
	
	@PostMapping(path = "/add")
	@Operation(summary = "Add User")
	public List<TmsUserInfo> addUser(@RequestBody TmsUserInfo request) {
		System.out.println("Request =>>>>>>>>>>>>>>>>>>>>>>>>>>"+request);
		return tmsUserService.addUser(request);
	}
	
	@PostMapping(path = "/list")
	@Operation(summary = "List of Users")
	public ResponseEntity<List<TmsUserInfo>> userList(@RequestBody TmsUserInfo request) {
		List<TmsUserInfo> list = tmsUserService.list(request);
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(list);
	}

	@DeleteMapping(path = "/delete")
	@Operation(summary = "Delete User")
	public ResponseEntity<String> deleteUser(@RequestParam("recordId") Long recordId) {
		String status = tmsUserService.deleteUser(recordId);
		if(TmsCodes.FAIL.name().equalsIgnoreCase(status)) {
			return ResponseEntity.status(HttpStatusCode.valueOf(406)).body(TmsCodes.FAIL.name());
		}
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(TmsCodes.SUCCESS.name());
	}

}

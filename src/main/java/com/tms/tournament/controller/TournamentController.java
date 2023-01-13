package com.tms.tournament.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tms.tournament.beans.TournamentInfo;
import com.tms.tournament.services.TournamentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/tournament")
public class TournamentController {
	
	@Autowired
	private TournamentService service;
	
	@PostMapping(path = "/list")
	public List<TournamentInfo> list(@RequestBody TournamentInfo request) {
		return service.findAllTournaments();
	}
	
	@GetMapping(path = "/find")
	public TournamentInfo findTournament(@RequestParam Long recordId) {
		return service.findTournament(recordId);
	}
	
	@PostMapping(path = "/add")
	public List<TournamentInfo> add(@RequestBody TournamentInfo request) {
		return service.savOrUpdate(request);
	}
	
	@DeleteMapping(path = "/delete")
	public List<TournamentInfo> add(@RequestParam Long recordId) {
		return service.delete(recordId);
	}
	
	@RequestMapping(path = "/upload/logo", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public List<TournamentInfo> uploadLogo(@RequestPart MultipartFile file, @RequestParam Long recordId) {
		System.out.println("File Information =>"+file+ " : "+recordId);
		return service.uploadLog(file, recordId);
	}
	
}

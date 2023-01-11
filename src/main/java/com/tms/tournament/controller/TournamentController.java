package com.tms.tournament.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
}

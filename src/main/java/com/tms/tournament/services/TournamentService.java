package com.tms.tournament.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tms.commons.utils.Lists;
import com.tms.tournament.beans.TournamentInfo;
import com.tms.tournament.beans.TournamentUtils;
import com.tms.tournament.repository.TournamentRepository;
import com.tms.tournament.repository.entity.TournamentEntity;

@Component
public class TournamentService {
	
	@Autowired
	private TournamentRepository tournamentRepository;

	public List<TournamentInfo> findAllTournaments() {
		List<TournamentEntity> list = Lists.newArrayList();
		list = tournamentRepository.findAll();
		List<TournamentInfo> infoList = list.stream().map(e -> TournamentUtils.covertTournamentEntry(e)).collect(Collectors.toList());
		return infoList;
	}
	
	public TournamentInfo findTournament(Long recordId) {
		Optional<TournamentEntity> entity = tournamentRepository.findById(recordId);
		if(!entity.isPresent()) {
			throw new ObjectNotFoundException(TournamentEntity.class, "Tournament Entity Not Found");
			
		}
		return TournamentUtils.covertTournamentEntry(entity.get()); 
	}
	
	
}

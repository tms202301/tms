package com.tms.tournament.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
		List<TournamentInfo> infoList = list.stream().map(e -> TournamentUtils.covertTournamentInfo(e)).collect(Collectors.toList());
		return infoList;
	}
	
	public TournamentInfo findTournament(Long recordId) {
		Optional<TournamentEntity> entity = tournamentRepository.findById(recordId);
		if(!entity.isPresent()) {
			throw new ObjectNotFoundException(TournamentEntity.class, "Tournament Entity Not Found");
			
		}
		return TournamentUtils.covertTournamentInfo(entity.get()); 
	}

	public List<TournamentInfo> savOrUpdate(TournamentInfo request) {
		TournamentEntity entity = TournamentUtils.covertTournamentEntry(request);
		try {
			tournamentRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findAllTournaments();
	}

	public List<TournamentInfo> delete(Long recordId) {
		Optional<TournamentEntity> entity = tournamentRepository.findById(recordId);
		if(entity.isPresent()) {
			tournamentRepository.delete(entity.get());
		}
		return findAllTournaments();
	}

	public List<TournamentInfo> uploadLog(MultipartFile multipartFile, Long recordId) {
		if(null != recordId && null != multipartFile) {
			Optional<TournamentEntity> entity = tournamentRepository.findById(recordId);
			if(entity.isPresent()) {
				TournamentEntity e = entity.get();
				try {
					System.out.println("Logo Data =>"+multipartFile.getBytes());
					e.setLogoData(multipartFile.getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				tournamentRepository.save(e);
			}
		}
		return findAllTournaments();
	}
	
	
}

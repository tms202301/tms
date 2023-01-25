package com.tms.tournament.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.tournament.repository.entity.TournamentEntity;

@Repository
public interface TournamentRepository extends JpaRepository<TournamentEntity, Long> {
	
	List<TournamentEntity> findByFromDateGreaterThan(Long date);
	
	List<TournamentEntity> findByFromDateLessThan(Long date);
}

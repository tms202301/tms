package com.tms.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.tournament.repository.entity.TournamentEntity;

@Repository
public interface TournamentRepository extends JpaRepository<TournamentEntity, Long> {

}

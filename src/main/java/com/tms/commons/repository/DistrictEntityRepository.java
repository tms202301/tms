package com.tms.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.commons.repository.entity.DistrictEntity;
import com.tms.commons.repository.entity.StateEntity;
import com.tms.tournament.repository.entity.TournamentEntity;

@Repository
public interface DistrictEntityRepository extends JpaRepository<DistrictEntity, Long> {
	
	List<DistrictEntity> findAll();
	List<DistrictEntity> findBystateEntityRecordId(Long recordId);
}

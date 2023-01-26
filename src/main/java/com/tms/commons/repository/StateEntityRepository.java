package com.tms.commons.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tms.commons.repository.entity.StateEntity;

@Repository
public interface StateEntityRepository extends JpaRepository<StateEntity, Long> {
	
	List<StateEntity> findAll();
	
}

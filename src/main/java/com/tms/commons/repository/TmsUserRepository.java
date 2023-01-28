package com.tms.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.commons.repository.entity.TmsUserEntity;

public interface TmsUserRepository extends JpaRepository<TmsUserEntity, Long> {
	
	public TmsUserEntity findByUserName(String userName);

}

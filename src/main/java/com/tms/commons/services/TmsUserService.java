package com.tms.commons.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tms.commons.utils.TmsCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tms.commons.beans.TmsUserInfo;
import com.tms.commons.repository.TmsUserRepository;
import com.tms.commons.repository.entity.TmsUserEntity;
import com.tms.commons.utils.CommonsUtil;

@Component
public class TmsUserService {

	Logger LOGGER = LoggerFactory.getLogger(TmsUserService.class);
	@Autowired
	private TmsUserRepository repository;

	public List<TmsUserInfo> addUser(TmsUserInfo request) {
		repository.save(CommonsUtil.convertTmsUserEntity(request));
		LOGGER.info("Added the user of {}", request.getUserName());
		return list(request);
	}
	
	public List<TmsUserInfo> list(TmsUserInfo request) {
		List<TmsUserEntity> list = repository.findAll();
		return list.stream().map(e -> CommonsUtil.convertTmsUserInfo(e)).collect(Collectors.toList());
	}

	public String deleteUser(Long recordId) {
		LOGGER.info("deleteUser Start");
		Optional<TmsUserEntity> entity = repository.findById(recordId);
		if(entity.isPresent()) {
			repository.delete(entity.get());
			return TmsCodes.SUCCESS.name();
		}
		LOGGER.info("deleteUser End");
		return TmsCodes.FAIL.name();
	}
}

package com.tms.commons.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tms.commons.beans.TmsUserResponse;
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

	public TmsUserResponse addUser(TmsUserInfo request) {
		TmsUserEntity entity = repository.findByUserName(request.getUserName());
		String msg = "Invalid input";
		TmsUserResponse response = new TmsUserResponse();
		if(null != request.getRecordId() && request.getRecordId().intValue() == -1) {
			msg = "User updated successfully";
			if( null != entity) {
				response.setStatus(TmsCodes.FAIL.name());
				response.setMessage("User already exits with "+request.getUserName());
				return response;
			} else {
				msg = "User added successfully";
				entity = CommonsUtil.convertTmsUserEntity(request);
			}
			repository.save(entity);
			response = list(request);
			response.setMessage(msg);
		} else {
			response.setStatus(TmsCodes.FAIL.name());
			response.setMessageCode("1000");
			response.setMessage(msg);
		}
		return response;
	}
	
	public TmsUserResponse list(TmsUserInfo request) {
		List<TmsUserEntity> list = repository.findAll();
		TmsUserResponse response = new TmsUserResponse();
		response.setUsers(list.stream().map(e -> CommonsUtil.convertTmsUserInfo(e)).collect(Collectors.toList()));
		response.setStatus(TmsCodes.SUCCESS.name());
		return response;
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

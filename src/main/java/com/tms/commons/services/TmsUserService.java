package com.tms.commons.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tms.commons.beans.TmsUserInfo;
import com.tms.commons.repository.TmsUserRepository;
import com.tms.commons.repository.entity.TmsUserEntity;
import com.tms.commons.utils.CommonsUtil;

@Component
public class TmsUserService {
	
	@Autowired
	private TmsUserRepository repository;

	public List<TmsUserInfo> addUser(TmsUserInfo request) {
		repository.save(CommonsUtil.convertTmsUserEntity(request));
		return list(request);
	}
	
	public List<TmsUserInfo> list(TmsUserInfo request) {
		List<TmsUserEntity> list = repository.findAll();
		return list.stream().map(e -> CommonsUtil.convertTmsUserInfo(e)).collect(Collectors.toList());
	}
}

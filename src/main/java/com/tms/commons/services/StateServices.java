package com.tms.commons.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tms.commons.beans.StateInfo;
import com.tms.commons.repository.StateEntityRepository;
import com.tms.commons.repository.entity.StateEntity;
import com.tms.commons.utils.CommonsUtil;
import com.tms.commons.utils.Lists;

@Component
public class StateServices {

	@Autowired
	private StateEntityRepository stateEntityRepository;

	public List<StateInfo> findAllStates() {
		List<StateEntity> list = Lists.newArrayList();
		list = stateEntityRepository.findAll();
		List<StateInfo> infoList = convertToInfo(list);
		return infoList;
	}

	private List<StateInfo> convertToInfo(List<StateEntity> list) {
		List<StateInfo> infoList = list.stream().map(e -> CommonsUtil.covertStateInfo(e)).collect(Collectors.toList());
		return infoList;
	}
}

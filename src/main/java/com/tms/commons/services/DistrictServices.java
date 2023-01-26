package com.tms.commons.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tms.commons.beans.DistrictInfo;
import com.tms.commons.repository.StateEntityRepository;
import com.tms.commons.repository.entity.DistrictEntity;
import com.tms.commons.utils.CommonsUtil;
import com.tms.commons.utils.Lists;

@Component
public class DistrictServices {

	
	@Autowired
	private StateEntityRepository stateEntityRepository;
	 
	public List<DistrictInfo> findDistrictByStates(Long stateId) {
		List<DistrictEntity> list = Lists.newArrayList();		
		list = stateEntityRepository.findById(stateId).get().getDistrictList();
		List<DistrictInfo> infoList = convertToInfo(list);
		return infoList;
	}

	private List<DistrictInfo> convertToInfo(List<DistrictEntity> list) {
		List<DistrictInfo> infoList = list.stream().map(e -> CommonsUtil.covertDistrictInfo(e)).collect(Collectors.toList());
		return infoList;
	}
}

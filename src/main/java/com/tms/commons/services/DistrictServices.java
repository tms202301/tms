package com.tms.commons.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tms.commons.beans.DistrictInfo;
import com.tms.commons.repository.DistrictEntityRepository;
import com.tms.commons.repository.entity.DistrictEntity;
import com.tms.commons.utils.CommonsUtil;
import com.tms.commons.utils.Lists;

@Component
public class DistrictServices {

	@Autowired
	private DistrictEntityRepository districtEntityRepository;

	public List<DistrictInfo> findDistrictByStates(Long stateId) {
		List<DistrictEntity> list = Lists.newArrayList();
		list = districtEntityRepository.findBystateEntityRecordId(stateId);
		List<DistrictInfo> infoList = convertToInfo(list);
		return infoList;
	}

	private List<DistrictInfo> convertToInfo(List<DistrictEntity> list) {
		List<DistrictInfo> infoList = list.stream().map(e -> CommonsUtil.covertDistrictInfo(e)).collect(Collectors.toList());
		return infoList;
	}
}

package com.tms.commons.utils;

import com.tms.commons.beans.DistrictInfo;
import com.tms.commons.beans.StateInfo;
import com.tms.commons.repository.entity.DistrictEntity;
import com.tms.commons.repository.entity.StateEntity;

public class CommonsUtil {
	public static StateInfo covertStateInfo(StateEntity entity) {
		StateInfo info = new StateInfo();
		info.setName(entity.getName());		
		info.setId(entity.getRecordId());
		return info;
	}
	public static DistrictInfo covertDistrictInfo(DistrictEntity entity) {
		DistrictInfo info = new DistrictInfo();
		info.setName(entity.getName());		
		info.setId(entity.getRecordId());
		return info;
	}
}

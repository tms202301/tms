package com.tms.commons.utils;

import com.tms.commons.beans.DistrictInfo;
import com.tms.commons.beans.StateInfo;
import com.tms.commons.beans.TmsUserInfo;
import com.tms.commons.repository.entity.DistrictEntity;
import com.tms.commons.repository.entity.StateEntity;
import com.tms.commons.repository.entity.TmsUserEntity;

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
	
	public static TmsUserEntity convertTmsUserEntity(TmsUserInfo info) {
		TmsUserEntity entity = new TmsUserEntity();
		entity.setFirstName(info.getFirstName());
		entity.setLastName(info.getLastName());
		entity.setUserName(info.getUserName());
		entity.setPassword(info.getPassword());
		entity.setEmail(info.getEmail());
		entity.setDateOfBirth(info.getDateOfBirth());
		entity.setMobileNumber(info.getMobileNumber());
		entity.setPanNumber(info.getPanNumber());
		return entity;
	}
	
	public static TmsUserInfo convertTmsUserInfo(TmsUserEntity entity) {
		TmsUserInfo info = new TmsUserInfo();
		info.setFirstName(entity.getFirstName());
		info.setLastName(entity.getLastName());
		info.setUserName(entity.getUserName());
		info.setPassword(entity.getPassword());
		info.setEmail(entity.getEmail());
		info.setDateOfBirth(entity.getDateOfBirth());
		info.setMobileNumber(entity.getMobileNumber());
		info.setPanNumber(entity.getPanNumber());
		return info;
	}
}

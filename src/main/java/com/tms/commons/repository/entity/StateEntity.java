package com.tms.commons.repository.entity;

import java.util.List;

import com.tms.commons.repository.AuditListener;
import com.tms.commons.repository.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
@Entity(name = "ALLSTATES")
@EntityListeners(AuditListener.class)
public class StateEntity extends BaseEntity{
	@Column(name = "NAME")
	private String name;
	@OneToMany(mappedBy = "stateEntity",fetch = FetchType.LAZY)
	private List<DistrictEntity> districtList; 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DistrictEntity> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<DistrictEntity> districtList) {
		this.districtList = districtList;
	}
	
	
}

package com.tms.commons.repository.entity;

import com.tms.commons.repository.AuditListener;
import com.tms.commons.repository.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity(name = "DISTRICT")
@EntityListeners(AuditListener.class)
public class DistrictEntity extends BaseEntity{
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="STATE_ENTITY_RECORD_ID")
	StateEntity stateEntity;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateEntity getStateEntity() {
		return stateEntity;
	}

	public void setStateEntity(StateEntity stateEntity) {
		this.stateEntity = stateEntity;
	}
	
}

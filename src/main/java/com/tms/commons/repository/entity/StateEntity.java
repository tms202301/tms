package com.tms.commons.repository.entity;

import com.tms.commons.repository.AuditListener;
import com.tms.commons.repository.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
@Entity(name = "ALLSTATES")
@EntityListeners(AuditListener.class)
public class StateEntity extends BaseEntity{
	@Column(name = "NAME")
	private String name;
}

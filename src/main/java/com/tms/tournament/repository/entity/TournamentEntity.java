package com.tms.tournament.repository.entity;

import com.tms.commons.repository.AuditListener;
import com.tms.commons.repository.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TOURNAMENTS")
@EntityListeners(AuditListener.class)
@Setter
@Getter
public class TournamentEntity extends BaseEntity {
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "FROM_DATE")
	private Long fromDate;
	@Column(name = "TO_DATE")
	private Long toDate;
	@Column(name = "VENUE")
	private String venue;
	@Column(name = "GAME_NAME")
	private String gameName;
	@Column(name = "TN_TYPE")
	private Integer type;
	@Column(name = "TN_CATEGORY")
	private Integer category;
	@Column(name = "PROMOTERS")
	private String promoters;
	@Column(name = "ORGANIZER")
	private String organizer;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ADMISION_START")
	private Long admisionStart;
	@Column(name = "ADMISION_END")
	private Long admisionEnd;
	@Column(name = "TN_ID")
	private String id;
	@Column(name = "LOGO_DATA", columnDefinition = "blob")
	private byte[] logoData;
}

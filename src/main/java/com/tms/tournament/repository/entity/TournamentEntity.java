package com.tms.tournament.repository.entity;

import com.tms.commons.repository.AuditListener;
import com.tms.commons.repository.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;

@Entity(name = "TOURNAMENTS")
@EntityListeners(AuditListener.class)
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFromDate() {
		return fromDate;
	}
	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}
	public Long getToDate() {
		return toDate;
	}
	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getPromoters() {
		return promoters;
	}
	public void setPromoters(String promoters) {
		this.promoters = promoters;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAdmisionStart() {
		return admisionStart;
	}
	public void setAdmisionStart(Long admisionStart) {
		this.admisionStart = admisionStart;
	}
	public Long getAdmisionEnd() {
		return admisionEnd;
	}
	public void setAdmisionEnd(Long admisionEnd) {
		this.admisionEnd = admisionEnd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getLogoData() {
		return logoData;
	}
	public void setLogoData(byte[] logoData) {
		this.logoData = logoData;
	}
	
}

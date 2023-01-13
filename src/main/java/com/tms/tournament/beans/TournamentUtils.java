package com.tms.tournament.beans;

import com.tms.tournament.repository.entity.TournamentEntity;

public class TournamentUtils {
	public static TournamentInfo covertTournamentInfo(TournamentEntity entity) {
		TournamentInfo info = new TournamentInfo();
		info.setName(entity.getName());
		info.setFromDate(entity.getFromDate());
		info.setToDate(entity.getToDate());
		info.setGameName(entity.getGameName());
		info.setRecordId(entity.getRecordId());
		info.setOrganizer(entity.getOrganizer());
		info.setPromoters(entity.getPromoters());
		info.setAdmisionEnd(entity.getAdmisionEnd());
		info.setAdmisionStart(entity.getAdmisionStart());
		info.setDescription(entity.getDescription());
		info.setCategory(entity.getCategory());
		info.setVenue(entity.getVenue());
		info.setType(entity.getType());
		info.setId(entity.getId());
		info.setLogoData(entity.getLogoData());
		return info;
	}
	
	public static TournamentEntity covertTournamentEntry(TournamentInfo tenantInfo) {
		TournamentEntity tenantEntity = new TournamentEntity();
		tenantEntity.setName(tenantInfo.getName());
		tenantEntity.setFromDate(tenantInfo.getFromDate());
		tenantEntity.setToDate(tenantInfo.getToDate());
		tenantEntity.setGameName(tenantInfo.getGameName());
		tenantEntity.setRecordId(tenantInfo.getRecordId());
		tenantEntity.setOrganizer(tenantInfo.getOrganizer());
		tenantEntity.setPromoters(tenantInfo.getPromoters());
		tenantEntity.setAdmisionEnd(tenantInfo.getAdmisionEnd());
		tenantEntity.setAdmisionStart(tenantInfo.getAdmisionStart());
		tenantEntity.setDescription(tenantInfo.getDescription());
		tenantEntity.setCategory(tenantInfo.getCategory());
		tenantEntity.setVenue(tenantInfo.getVenue());
		tenantEntity.setType(tenantInfo.getType());
		tenantEntity.setId(tenantInfo.getId());
		return tenantEntity;
	}

}

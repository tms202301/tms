package com.tms.tournament.beans;

import com.tms.tournament.repository.entity.TournamentEntity;

public class TournamentUtils {
	public static TournamentInfo covertTournamentEntry(TournamentEntity entity) {
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
		return info;
	}

}

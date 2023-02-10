package com.tms.tournament.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TournamentInfo {
	private String name;
	private Long fromDate;
	private Long toDate;
	private String venue;
	private String gameName;
	private Integer type;
	private Integer category;
	private String promoters;
	private String organizer;
	private String description;
	private Long admisionStart;
	private Long admisionEnd;
	private Long recordId;
	private String id;
	private byte[] logoData;
	
}

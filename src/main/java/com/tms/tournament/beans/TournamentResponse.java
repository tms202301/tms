package com.tms.tournament.beans;

import com.tms.commons.beans.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TournamentResponse extends BaseResponse {
    private List<TournamentInfo> tournamentInfos;
}

package com.tms.player.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.commons.utils.Lists;
import com.tms.player.beans.PlayerVo;


@RestController
public class PlayerController {
	
	Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);
	
	@GetMapping(path = "/player/list")
	public List<PlayerVo> playersList() {
		LOGGER.info("playersList : Start");
		List<PlayerVo> list = Lists.newArrayList();
		PlayerVo bean = new PlayerVo();
		bean.setRecordId(1l);
		bean.setFirstName("Sreenivasulu");
		list.add(bean);
		bean = new PlayerVo();
		bean.setRecordId(2l);
		bean.setFirstName("Raman");
		list.add(bean);
		bean = new PlayerVo();
		bean.setRecordId(3l);
		bean.setFirstName("Loukya");
		list.add(bean);
		LOGGER.info("playersList : End");
		return list;
	}
}

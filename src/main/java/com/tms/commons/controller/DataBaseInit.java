package com.tms.commons.controller;

import com.tms.commons.repository.TmsUserRepository;
import com.tms.commons.repository.entity.TmsUserEntity;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataBaseInit {

    Logger LOGGER = LoggerFactory.getLogger(DataBaseInit.class);

    @Autowired
    private TmsUserRepository repository;

    @PostConstruct
    public void addUserDefaultUser() {
        TmsUserEntity entity = new TmsUserEntity();
        entity.setUserName("system");
        entity.setPassword("password1#");
        entity.setDateOfBirth(System.currentTimeMillis());
        TmsUserEntity dbObject = repository.findByUserName("system");
        if(null == dbObject) {
            repository.save(entity);
        } else {
            LOGGER.info("System user already exits !!!");
        }

    }
}

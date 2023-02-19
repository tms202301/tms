package com.tms.commons.repository.listner;

import com.tms.commons.repository.TmsUserRepository;
import com.tms.commons.repository.entity.TmsUserEntity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TmsUserListener {
    @Autowired
    private TmsUserRepository repository;

    @PostPersist
    @PostUpdate
    public void afterPersist(final TmsUserEntity entity){
        entity.setUpdatedOn(System.currentTimeMillis());
        entity.setCreatedOn(System.currentTimeMillis());
        if(null != repository) {
            repository.save(entity);
        }
    }
}

package com.tms.commons.repository;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tms.tournament.repository.entity.TournamentEntity;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Component
public class AuditListener<T> {
	
	Logger LOGGER = LoggerFactory.getLogger(AuditListener.class);

	@PrePersist
    public void onPrePrist(final T entity){
		LOGGER.debug("entity =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.{}", entity);
    }
	
    @PostPersist 
    @PostUpdate
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void afterPresist(final T entity){
    	LOGGER.debug("saved =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> {}", entity);
        Class<?> c = entity.getClass();
		Object entityObject = null;
		entityObject = getInstance(c, entity);
		if(null != entityObject) {
			for (Method method : c.getDeclaredMethods()) {
				try {
					if(method.getName().startsWith("get")) {
						LOGGER.debug("Attribute Info=> {} : {}",method.getName(), method.invoke(entityObject));
					}
				} catch (Exception e) {
					LOGGER.error("Error in Audit Trail ", e);
				}
			}
			for (Method method : c.getSuperclass().getDeclaredMethods()) {
				try {
					if(method.getName().startsWith("get")) {
						LOGGER.debug("Attribute Info=> {} : {}",method.getName(), method.invoke(entityObject));
					}
				} catch (Exception e) {
					LOGGER.error("Error in Audit Trail for sueper class", e);
				}
			}
		}
    }
    
    @PreUpdate
    public void onUpdate(final T toUpdate){
    	LOGGER.debug("toUpdate =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", toUpdate);
    }
    
    private Object getInstance(Class<?> c, final T entity) {
    	Object entityObject = null;
    	if("TournamentEntity".equalsIgnoreCase(c.getSimpleName())) {
    		entityObject = (TournamentEntity) entity;
    	}
    	return entityObject;
    }
}

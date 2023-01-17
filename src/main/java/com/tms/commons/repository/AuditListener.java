package com.tms.commons.repository;

import java.lang.reflect.Method;

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

	@PrePersist
    public void onPrePrist(final T entity){
		System.out.println("entity =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+entity);
    }
	
    @PostPersist 
    @PostUpdate
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void afterPresist(final T entity){
        System.out.println("saved =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+entity);
        Class<?> c = entity.getClass();
		Object entityObject = null;
		System.out.println(c.getName()+" : "+c.getSimpleName());
		entityObject = (TournamentEntity) entity;
		if(null != entityObject) {
			for (Method method : c.getDeclaredMethods()) {
				try {
					if(method.getName().startsWith("get")) {
						System.out.println(method.getName()+" : "+method.invoke(entityObject));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (Method method : c.getSuperclass().getDeclaredMethods()) {
				try {
					if(method.getName().startsWith("get")) {
						System.out.println(method.getName()+" : "+method.invoke(entityObject));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    @PreUpdate
    public void onUpdate(final T toUpdate){
    	System.out.println("toUpdate =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+toUpdate);
    }
}

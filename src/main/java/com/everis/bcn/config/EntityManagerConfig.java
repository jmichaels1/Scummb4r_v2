package com.everis.bcn.config;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author J Michael
 *
 */
@Component
public class EntityManagerConfig {
	
	private EntityManager entityManager;

	/***
	 * M�todo Constructor
	 * @param entityManager
	 */
	public EntityManagerConfig(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	/*** Getters and Setters ***/

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

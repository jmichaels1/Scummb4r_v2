package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Turn;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 */
@Repository
public class TurnDAOImp implements Dao<Turn> {
	
	private EntityManager entityManager = new AnnotationConfigApplicationContext(AppConfig.class)
			.getBean(EntityManagerConfig.class).getEntityManager();
	
	@Override
	public void save(Turn turn) {
		entityManager.getTransaction().begin();
		entityManager.persist(turn);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Turn turn) {
		entityManager.getTransaction().begin();
		entityManager.merge(turn);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Turn get(int id) {
		return entityManager.find(Turn.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Turn> getAll() {
		System.out.println("entityManager is null : " + entityManager);
		return Sets.newHashSet((ArrayList<Turn>) entityManager
				.createQuery("Select a From Turn a", Turn.class)
				.getResultList());
	}

}

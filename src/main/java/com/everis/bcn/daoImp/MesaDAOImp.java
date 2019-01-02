package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public class MesaDAOImp implements Dao<Mesa> {
	
	private EntityManager entityManager = new AnnotationConfigApplicationContext(AppConfig.class)
			.getBean(EntityManagerConfig.class).getEntityManager();
	
	
	@Override
	public void save(Mesa mesa) {
		entityManager.getTransaction().begin();
		entityManager.persist(mesa);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Mesa mesa) {
		entityManager.getTransaction().begin();
		entityManager.merge(mesa);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Mesa get(int id) {
		return entityManager.find(Mesa.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Mesa> getAll() {
		return Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a From Mesa a", Mesa.class)
				.getResultList());
	}
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId) {
		Set<Mesa> r = Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a From Mesa a where a.restaurant.id = " + restaurantId, Mesa.class)
				.getResultList());
		
		for (Mesa mesa : r) {
			System.out.println("getMesasIdOfTheRestaurant : " + mesa);
		}
		return r;
	}
}

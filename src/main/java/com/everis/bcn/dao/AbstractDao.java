package com.everis.bcn.dao;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.entity.Booking;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 * @param <T>
 */
@Repository
public class AbstractDao<T> implements Dao<T> {
	
	@Autowired protected EntityManager entityManager;
	private Class< T > clazz;

	@Override
	public void save(T t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(T t) {
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
	}

	@Override
	public T get(int id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> getAll() {
		return (Set<T>) Sets.newHashSet((ArrayList<Booking>) entityManager
				.createQuery("From " + clazz.getName())
				.getResultList());
	}
	
	/****** Added Method's ******/
	
	
	/**
	 * Injection generic Class
	 * @param clazzToSet
	 */
	public void setClazz( Class< T > clazzToSet ) {
	      this.clazz = clazzToSet;
	   }

}

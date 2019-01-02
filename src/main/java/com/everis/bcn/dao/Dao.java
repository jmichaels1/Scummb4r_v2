package com.everis.bcn.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;

/**
 * 
 * @author J Michael
 *
 * @param <T>
 */
public interface Dao<T> {
	
	void save(T t);
	void update(T t);
	T get(int id);
	void delete(int id);
	Set<T> getAll();
	
}

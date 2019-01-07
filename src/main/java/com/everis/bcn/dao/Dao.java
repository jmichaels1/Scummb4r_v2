package com.everis.bcn.dao;

import java.util.Set;

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

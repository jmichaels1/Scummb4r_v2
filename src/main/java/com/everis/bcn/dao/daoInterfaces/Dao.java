package com.everis.bcn.dao.daoInterfaces;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author J Michael
 *
 * @param <T>
 */
public interface Dao<T extends Serializable> {
	
	void save(T t);
	void update(T t);
	T get(int id);
	void delete(int id);
	Set<T> getAll();
	
}

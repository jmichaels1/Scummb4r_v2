package com.everis.bcn.dao.daoInterfaces;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.everis.bcn.entity.Restaurant;

/***
 * 
 * @author J Michael
 *
 */
@Repository
public interface RestaurantDao extends Dao<Restaurant> {
	
	/**
	 * get restaurant object
	 * from restaurantName
	 * @param restaurantName
	 * @return
	 */
	public Restaurant get(String restaurantName);
}


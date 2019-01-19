package com.everis.bcn.dao;

import com.everis.bcn.entity.Restaurant;

/***
 * 
 * @author J Michael
 *
 */
public interface RestaurantDao extends Dao<Restaurant> {
	
	/**
	 * get restaurant object
	 * from restaurantName
	 * @param restaurantName
	 * @return
	 */
	public Restaurant get(String restaurantName);
}


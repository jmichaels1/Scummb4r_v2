package com.everis.bcn.dao.impl;

import org.springframework.stereotype.Repository;
import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.entity.Restaurant;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public class RestaurantDAOImp extends AbstractDao<Restaurant> {
	
	/**
	 * get restaurant object
	 * from restaurantName
	 * @param restaurantName
	 * @return
	 */
	public Restaurant get(String restaurantName) {
		return  entityManager
				.createQuery("Select a From Restaurant a where a.name = '" + restaurantName + "'", Restaurant.class)
				.getSingleResult();
	}
}

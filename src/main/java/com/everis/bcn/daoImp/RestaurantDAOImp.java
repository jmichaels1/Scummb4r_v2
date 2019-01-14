package com.everis.bcn.daoImp;

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
	
	public Restaurant get(String restaurantName) {
		Restaurant rest = entityManager
				.createQuery("Select a From Restaurant a where a.name = '" + restaurantName + "'", Restaurant.class)
				.getSingleResult();
		return  rest;
	}
}

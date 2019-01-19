package com.everis.bcn.dao.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.dao.RestaurantDao;
import com.everis.bcn.entity.Restaurant;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public class RestaurantDAOImp extends AbstractDao<Restaurant> implements RestaurantDao {
	
	/**
	 * inject Entity class in Dao
	 */
	@Autowired
	public void setDao() {
		setClazz(Restaurant.class);
	}
	
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

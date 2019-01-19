package com.everis.bcn.dao;

import java.util.Set;

import com.everis.bcn.entity.Mesa;


/**
 * 
 * @author J Michael
 *
 */
public interface MesaDao extends Dao<Mesa> {
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId);
}

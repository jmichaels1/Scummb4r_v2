package com.everis.bcn.dao.daoInterfaces;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.everis.bcn.entity.Mesa;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public interface MesaDao extends Dao<Mesa> {
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId);
}

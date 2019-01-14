package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public class MesaDAOImp extends AbstractDao<Mesa> {
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId) {
		Set<Mesa> r = Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a From Mesa a where a.restaurant.id = " + restaurantId, Mesa.class)
				.getResultList());
		
		for (Mesa mesa : r) {
			System.out.println("getMesasIdOfTheRestaurant : " + mesa);
		}
		return r;
	}
}

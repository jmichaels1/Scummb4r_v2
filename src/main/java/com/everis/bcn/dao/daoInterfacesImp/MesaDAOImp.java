package com.everis.bcn.dao.daoInterfacesImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.daoAbstract.AbstractDao;
import com.everis.bcn.dao.daoInterfaces.MesaDao;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
@Repository
public class MesaDAOImp extends AbstractDao<Mesa> implements MesaDao {
	
	/**
	 * inject Entity class in Dao
	 */
	@Autowired
	public void setDao() {
		setClazz(Mesa.class);
	}
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId) {
		return Sets.newHashSet((List<Mesa>) entityManager
				.createQuery("Select a From Mesa a where a.restaurant.id = " + restaurantId, Mesa.class)
				.getResultList());
	}
}

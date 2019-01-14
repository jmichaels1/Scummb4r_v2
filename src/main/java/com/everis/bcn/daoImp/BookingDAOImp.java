package com.everis.bcn.daoImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 */
@Repository
public class BookingDAOImp extends AbstractDao<Booking> {
		
	/**
	 * 
	 * @param restaurantId
	 * @param turnId
	 * @return
	 */
	public Set<Mesa> getMesasOfTheTurn(int restaurantId, int turnId, Date day){
		SimpleDateFormat FORMAT3 = new SimpleDateFormat("yyyy-MM-dd");
		Set<Mesa> s = Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a.mesa "
						+ "From Booking a "
						+ "where a.restaurant.id = " + restaurantId  
						+ " and a.day = '" +  FORMAT3.format(day) + "'" 
						+ " and a.turn.id = " + turnId, Mesa.class)
				.getResultList());
		return s;
	}
	
	/***
	 * 
	 * @param localizator
	 * @return
	 */
	public Booking get(long localizator) {
		return entityManager
				.createQuery("Select a "
						+ "From Booking a "
						+ "where a.localizador = " + localizator, Booking.class)
				.getResultList().stream().findFirst().orElse(null);
	}
}

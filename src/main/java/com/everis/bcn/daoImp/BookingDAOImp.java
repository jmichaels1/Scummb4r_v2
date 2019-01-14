package com.everis.bcn.daoImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
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
		return Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a.mesa "
						+ "From Booking a "
						+ "where a.restaurant.id = " + restaurantId  
						+ " and a.day = '" +  new SimpleDateFormat("yyyy-MM-dd").format(day) + "'" 
						+ " and a.turn.id = " + turnId, Mesa.class)
				.getResultList());
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

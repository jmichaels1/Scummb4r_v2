package com.everis.bcn.dao.Imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.dao.BookingDao;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 */
@Repository
public class BookingDAOImp extends AbstractDao<Booking> implements BookingDao {
	
	
	/**
	 * inject Entity class in Dao
	 */
	@Autowired
	public void setDao() {
		setClazz(Booking.class);
	}
		
	/**
	 * 
	 * @param restaurantId
	 * @param turnId
	 * @return
	 */
	@Override
	public Set<Mesa> getMesasOfTheTurn(Booking booking){
		return Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a.mesa "
						+ "From Booking a "
						+ "where a.restaurant.id = " + booking.getRestaurant().getRestaurantId()  
						+ " and a.day = '" +  new SimpleDateFormat("yyyy-MM-dd").format(booking.getDay()) + "'" 
						+ " and a.turn.id = " + booking.getTurn().getTurnId(), 
						Mesa.class)
				.getResultList());
	}
	
	/***
	 * 
	 * @param localizator
	 * @return
	 */
	@Override
	public Booking get(long localizator) {
		return entityManager
				.createQuery("Select a "
						+ "From Booking a "
						+ "where a.localizador = " + localizator, Booking.class)
				.getResultList().stream().findFirst().orElse(null);
	}
}

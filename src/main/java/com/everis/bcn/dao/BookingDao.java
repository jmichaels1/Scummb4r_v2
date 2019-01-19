package com.everis.bcn.dao;

import java.util.Set;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;

/***
 * 
 * @author J Michael
 *
 */
public interface BookingDao extends Dao<Booking> {
	
	public Set<Mesa> getMesasOfTheTurn(Booking booking);
	public Booking get(long localizator);

}

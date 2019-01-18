package com.everis.bcn.dao.daoInterfaces;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;

/***
 * 
 * @author J Michael
 *
 */
@Repository
public interface BookingDao extends Dao<Booking> {
	
	public Set<Mesa> getMesasOfTheTurn(Booking booking);
	public Booking get(long localizator);

}

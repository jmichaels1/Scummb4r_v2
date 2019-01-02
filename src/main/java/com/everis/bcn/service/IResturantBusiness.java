package com.everis.bcn.service;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author J Michael
 *
 */
public interface IResturantBusiness {
	
	public boolean editBooking(Booking booking);
	public boolean cancelBooking(Booking booking);
	public boolean reserve(Booking booking);
	public void addRestaurant(Restaurant restaurant);
	public Set<Restaurant> getRestaurants();
	public Set<Turn> getTurns();
	public Set<Booking> getBookings();
}

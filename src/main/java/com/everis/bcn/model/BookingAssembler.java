package com.everis.bcn.model;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.dto.Dto;
import com.everis.bcn.entity.Booking;


/***
 * 
 * @author J Michael
 *
 */
@Component
public class BookingAssembler{
	
	private Booking booking;

	public BookingAssembler() {
		super();
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	/**
	 * get booking from bookingDto
	 * @return
	 */
	public Booking getBookingFromDto(Dto dto, ModelMapper bookingMapper) {
		booking = new Booking();
		bookingMapper.map(dto, booking);
		return booking;
	}
	
	/***
	 * get booking from cancelDto
	 * @param dto
	 * @param cancelMapper
	 * @return
	 */
	public Booking getBookingFromCancelDto(CancelDto dto, ModelMapper cancelMapper) {
		booking = new Booking();
		cancelMapper.map(dto, booking);
		return booking;
	}
	
}

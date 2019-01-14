package com.everis.bcn.model;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
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

	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public Booking getBookingFromDto(Dto dto, ModelMapper modelMapper) {
		booking = new Booking();
		modelMapper.map(dto, booking);
		return booking;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}

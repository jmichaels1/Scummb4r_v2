package com.everis.bcn.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;

/***
 * 
 * @author jsalirio
 *
 */
@Component
public class ModdelMapperConfig {
	
	private ModelMapper modelMapperBooking;
	private ModelMapper modelMapperCancel;
	
	/***
	 * Constructor Default
	 */
	public ModdelMapperConfig() {
		modelMapperBookingConfig();
		modelMapperCancelConfig();
	}

	/**** getters and setters *****/

	public ModelMapper getModelMapperBooking() {
		return modelMapperBooking;
	}

	public void setModelMapperBooking(ModelMapper modelMapperBooking) {
		this.modelMapperBooking = modelMapperBooking;
	}

	public ModelMapper getModelMapperCancel() {
		return modelMapperCancel;
	}

	public void setModelMapperCancel(ModelMapper modelMapperCancel) {
		this.modelMapperCancel = modelMapperCancel;
	}
	
	/***** Metods Agregados ******/
	
	/**
	 * config modelmapper booking
	 * by reserve mapping
	 * @return
	 */
	public void modelMapperBookingConfig() {
		modelMapperBooking = new ModelMapper();
		modelMapperBooking.getConfiguration (). setAmbiguityIgnored (true);
		modelMapperBooking.addMappings(new PropertyMap<BookingDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturantFromDto()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurnFromDto());
				map().setPersonas(source.getPersons());
			}
		});
	}
	
	/**
	 * config modelmapper cancel booking
	 * @return
	 */
	public void modelMapperCancelConfig() {
		modelMapperCancel = new ModelMapper();
		modelMapperCancel.getConfiguration (). setAmbiguityIgnored (true);
		modelMapperCancel.addMappings(new PropertyMap<CancelDto, Booking>() {
			@Override
			protected void configure() {
				map().setLocalizador(source.getLocalizator());
			}
		});
	}
}

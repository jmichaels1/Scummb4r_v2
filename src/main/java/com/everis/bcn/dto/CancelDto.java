package com.everis.bcn.dto;

/**
 * 
 * @author J Michael
 *
 */
public class CancelDto extends Dto {
	
	private long localizator;
	
	/*** Getters And Setters ****/
	
	public long getLocalizator() {
		return localizator;
	}
	public void setLocalizator(long localizator) {
		this.localizator = localizator;
	}
}

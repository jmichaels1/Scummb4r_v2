package com.everis.bcn.dto;

import java.util.Date;

public class UpdateBookingDto {
	
	private long localizator;
	private String Restaurant;
	private Date day;
	private int turn;
	private int mesa;
	
	
	public long getLocalizator() {
		return localizator;
	}
	public void setLocalizator(long localizator) {
		this.localizator = localizator;
	}
	public String getRestaurant() {
		return Restaurant;
	}
	public void setRestaurant(String restaurant) {
		Restaurant = restaurant;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public String toString() {
		return "UpdateBookingDto [localizator=" + localizator + ", Restaurant=" + Restaurant + ", day=" + day
				+ ", turn=" + turn + ", mesa=" + mesa + "]";
	}
}

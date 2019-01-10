package com.everis.bcn.dto;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.model.DaoByDto;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author jsalirio
 *
 */
@Component
public class Dto {
	
	private String restaurantName;
	private Date day;
	private int turn;
	
	@Autowired private DaoByDto daoByDto;
	
	
	/*** Getters And Setters ****/
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantId) {
		this.restaurantName = restaurantId;
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
	
	
	public DaoByDto getDaoByDto() {
		return daoByDto;
	}
	public void setDaoByDto(DaoByDto daoByDto) {
		this.daoByDto = daoByDto;
	}
	
	
	
	/******* Métodos agregados **********/
	
	public Restaurant getResturantFromDto() {
		return daoByDto.getRest_dao().get(restaurantName);
	}
	
	
	public Turn getTurnFromDto() {
		return daoByDto.getTurn_dao().get(turn);
	}
}

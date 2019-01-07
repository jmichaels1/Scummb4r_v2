package com.everis.bcn.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;

@Component
public class DaoByDto {
	
	@Autowired private RestaurantDAOImp rest_dao;
	@Autowired private TurnDAOImp turn_dao;
	
	/**
	 * Constructor Method
	 */
	public DaoByDto() {
		super();  
	}
	
	/**** Getters and Setters ****/
	
	public RestaurantDAOImp getRest_dao() {
		return rest_dao;
	}
	public void setRest_dao(RestaurantDAOImp rest_dao) {
		this.rest_dao = rest_dao;
	}
	public TurnDAOImp getTurn_dao() {
		return turn_dao;
	}
	public void setTurn_dao(TurnDAOImp turn_dao) {
		this.turn_dao = turn_dao;
	}
}

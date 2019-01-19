package com.everis.bcn.dao.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.bcn.dao.AbstractDao;
import com.everis.bcn.dao.TurnDao;
import com.everis.bcn.entity.Turn;

@Repository
public class TurnDaoImp extends AbstractDao<Turn> implements TurnDao{
	
	/**
	 * inject Entity class in Dao
	 */
	@Autowired
	public void setDao() {
		setClazz(Turn.class);
	}

}

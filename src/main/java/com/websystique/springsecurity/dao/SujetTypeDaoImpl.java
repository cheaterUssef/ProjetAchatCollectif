package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.SujetType;

@Repository("sujetTypeDao")
public class SujetTypeDaoImpl extends AbstractDao<Integer, SujetType> implements SujetTypeDao {
	
	 @SuppressWarnings("unchecked")
	 public List<SujetType> findAllSujetTypes(){
	        Criteria crit = createEntityCriteria();
	        crit.addOrder(Order.asc("type"));
	        return (List<SujetType>)crit.list();
	    }

	@Override
	public SujetType findById(int id) {
		return getByKey(id);
	}

}

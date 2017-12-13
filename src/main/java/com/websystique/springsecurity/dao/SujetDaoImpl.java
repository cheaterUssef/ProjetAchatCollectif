package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Sujet;

@Repository("sujetDao")
public class SujetDaoImpl extends AbstractDao<Integer, Sujet> implements SujetDao{

	static final Logger logger = LoggerFactory.getLogger(SujetDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Sujet> findAllSujets() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        List<Sujet> sujets = (List<Sujet>) criteria.list();
        System.out.println("**************************************************");
        for (Sujet sujet : sujets) {
			System.out.println(sujet.toString());
		}
        System.out.println("**************************************************");
        return sujets;
    }

	@Override
	public void save(Sujet sujet) {
		persist(sujet);
	}

}

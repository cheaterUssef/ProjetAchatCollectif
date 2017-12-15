package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Sujet;
import com.websystique.springsecurity.model.User;

@Repository("sujetDao")
public class SujetDaoImpl extends AbstractDao<Integer, Sujet> implements SujetDao{

	static final Logger logger = LoggerFactory.getLogger(SujetDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Sujet> findAllSujets() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
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

	@Override
	public Sujet findById(int id) {
		Sujet sujet = getByKey(id);
        if(sujet!=null){
            Hibernate.initialize(sujet.getCommentaires());
        }
        return sujet;
	}

	@Override
	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Sujet sujet = (Sujet)crit.uniqueResult();
        delete(sujet);
	}

}

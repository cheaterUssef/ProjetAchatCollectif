package com.websystique.springsecurity.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.SujetDao;
import com.websystique.springsecurity.model.Sujet;

@Service("sujetService")
@Transactional
public class SujetServiceImpl implements SujetService{

	@Autowired
    private SujetDao dao;
	
	@Override
	public List<Sujet> findAllSujets() {
		return dao.findAllSujets();
	}

	@Override
	public void saveSujet(Sujet sujet) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
//		System.out.println(sujet.getDate_expiration());
		dao.save(sujet);
	}

	@Override
	public Sujet findById(int id) {
		return dao.findById(id);
	}

}

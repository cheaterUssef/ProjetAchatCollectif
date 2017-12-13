package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.SujetTypeDao;
import com.websystique.springsecurity.model.SujetType;

@Service("sujetTypeService")
@Transactional
public class SujetTypeServiceImpl implements SujetTypeService {

	@Autowired
    SujetTypeDao dao;
	
	@Override
	public List<SujetType> findAllSujetTypes() {
		return dao.findAllSujetTypes();
	}

	@Override
	public SujetType findById(int id) {
		return dao.findById(id);
	}

}

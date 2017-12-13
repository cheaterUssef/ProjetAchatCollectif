package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.SujetType;

public interface SujetTypeService {
	
	SujetType findById(int id);
	 
//    UserProfile findByType(String type);
     
    List<SujetType> findAllSujetTypes();
}

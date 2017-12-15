package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Sujet;

public interface SujetService {
	
	Sujet findById(int id);
    
//  User findBySSO(String sso);
   
	void saveSujet(Sujet sujet);
   
	void updateService(Sujet sujet);
   
	void deleteSujetById(int id);

	List<Sujet> findAllSujets(); 
   
//  boolean isUserSSOUnique(Integer id, String sso);

}

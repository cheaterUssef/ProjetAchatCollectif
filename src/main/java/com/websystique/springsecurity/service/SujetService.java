package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Sujet;

public interface SujetService {
	
//	User findById(int id);
    
//  User findBySSO(String sso);
   
  void saveSujet(Sujet sujet);
   
//  void updateUser(User user);
   
//  void deleteUserBySSO(String sso);

	List<Sujet> findAllSujets(); 
   
//  boolean isUserSSOUnique(Integer id, String sso);

}

package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Sujet;

public interface SujetDao {
	
//	User findById(int id);
    
//	User findBySSO(String sso);
//     
    void save(Sujet sujet);
//     
//    void deleteBySSO(String sso);
//     
	List<Sujet> findAllSujets();

}
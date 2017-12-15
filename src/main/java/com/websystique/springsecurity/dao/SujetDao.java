package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Sujet;

public interface SujetDao {
	
	Sujet findById(int id);
    
//	User findBySSO(String sso);
//     
    void save(Sujet sujet);
//     
    void deleteById(int id);
//     
	List<Sujet> findAllSujets();

}

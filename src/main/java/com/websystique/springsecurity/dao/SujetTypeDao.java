package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.SujetType;
import com.websystique.springsecurity.model.User;

public interface SujetTypeDao {
	SujetType findById(int id);
    
//    User findBySSO(String sso);
//     
//    void save(User user);
//     
//    void deleteBySSO(String sso);
     
    List<SujetType> findAllSujetTypes();

}

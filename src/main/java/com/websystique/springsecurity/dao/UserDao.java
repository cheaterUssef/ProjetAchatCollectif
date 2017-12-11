package com.websystique.springsecurity.dao;
 
import java.util.List;

import com.websystique.springsecurity.model.User;
 
public interface UserDao {
 
	User findById(int id);
    
    User findBySSO(String sso);
     
    void save(User user);
     
    void deleteBySSO(String sso);
     
    List<User> findAllUsers();
     
}
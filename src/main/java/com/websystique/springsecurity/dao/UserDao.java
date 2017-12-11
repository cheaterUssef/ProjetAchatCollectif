package com.websystique.springsecurity.dao;
 
import com.websystique.springsecurity.model.User;
 
public interface UserDao {
 
    void save(User user);
     
    User findById(int id);
     
    User findBySSO(String sso);
     
}
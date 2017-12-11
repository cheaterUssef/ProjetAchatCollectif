package com.websystique.springsecurity.dao;
 
import java.util.List;
 
import com.websystique.springsecurity.model.UserProfile;
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
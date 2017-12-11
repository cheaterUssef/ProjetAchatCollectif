package com.websystique.springsecurity.service;
 
import java.util.List;
 
import com.websystique.springsecurity.model.UserProfile;
 
public interface UserProfileService {
 
	UserProfile findById(int id);
	 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
}
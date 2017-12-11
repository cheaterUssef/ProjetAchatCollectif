package com.websystique.springsecurity.service;
 
import java.util.List;
 
import com.websystique.springsecurity.model.UserProfile;
 
public interface UserProfileService {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
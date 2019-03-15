package com.edu.springsecurity.hibernateintegration.service;

import com.edu.springsecurity.hibernateintegration.model.UserProfile;

import java.util.List;
 

public interface UserProfileService {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
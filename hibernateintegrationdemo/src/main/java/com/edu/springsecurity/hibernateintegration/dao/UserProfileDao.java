package com.edu.springsecurity.hibernateintegration.dao;

import com.edu.springsecurity.hibernateintegration.model.UserProfile;

import java.util.List;
 

public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}

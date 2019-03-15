package com.edu.springsecurity.springintergration.dao;

import com.edu.springsecurity.springintergration.model.UserProfile;

import java.util.List;



public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}

package com.edu.springsecurity.springintergration.service;

import com.edu.springsecurity.springintergration.model.UserProfile;

import java.util.List;



public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}

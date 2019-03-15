package com.edu.springsecurity.springintergration.service;

import java.util.List;

import com.edu.springsecurity.springintergration.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findBySSO(String username);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String username);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String username);

}
package com.edu.springsecurity.springintergration.dao;

import com.edu.springsecurity.springintergration.model.User;

import java.util.List;



public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}


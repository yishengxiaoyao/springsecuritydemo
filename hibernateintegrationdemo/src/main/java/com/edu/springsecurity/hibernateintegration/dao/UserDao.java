package com.edu.springsecurity.hibernateintegration.dao;


import com.edu.springsecurity.hibernateintegration.model.User;

public interface UserDao {

    void save(User user);
 
    User findById(int id);
     
    User findByUsername(String username);
     
}

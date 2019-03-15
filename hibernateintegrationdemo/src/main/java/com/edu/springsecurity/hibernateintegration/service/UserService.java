package com.edu.springsecurity.hibernateintegration.service;


import com.edu.springsecurity.hibernateintegration.model.User;

public interface UserService {

    void save(User user);
 
    User findById(int id);
     
    User findByUsername(String username);
     
}
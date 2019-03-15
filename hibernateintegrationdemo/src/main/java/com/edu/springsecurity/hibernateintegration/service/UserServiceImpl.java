package com.edu.springsecurity.hibernateintegration.service;

import com.edu.springsecurity.hibernateintegration.dao.UserDao;
import com.edu.springsecurity.hibernateintegration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
 
    public User findById(int id) {
        return dao.findById(id);
    }
 
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

}
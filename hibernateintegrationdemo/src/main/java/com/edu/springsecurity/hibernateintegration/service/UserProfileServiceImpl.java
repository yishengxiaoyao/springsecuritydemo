package com.edu.springsecurity.hibernateintegration.service;

import java.util.List;

import com.edu.springsecurity.hibernateintegration.dao.UserProfileDao;
import com.edu.springsecurity.hibernateintegration.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
     
    @Autowired
    UserProfileDao dao;
     
    public List<UserProfile> findAll() {
        return dao.findAll();
    }
 
    public UserProfile findByType(String type){
        return dao.findByType(type);
    }
 
    public UserProfile findById(int id) {
        return dao.findById(id);
    }
}

package com.workshop.security.service.impl;

import java.util.List;

import com.workshop.security.model.UserData;
import com.workshop.security.repository.UserDataRepository;
import com.workshop.security.service.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDataService{

    @Autowired
    UserDataRepository userDataRepository;

    BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    
    @Override
    public UserData createUser(UserData user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         return userDataRepository.save(user);
    }

    @Override
    public List<UserData> readAllUsers(UserData user) {
        return userDataRepository.findAll();
    }

    @Override
    public UserData readUserById(int userId) {
        return userDataRepository.findById(userId).get();
    }

    @Override
    public UserData readUserByUserName(String userName) {
        
        return userDataRepository.findByUserName(userName).get();
    }

    @Override
    public UserData updateUser(UserData user) {
        //UserData prev= userDataRepository.getById(user.getId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDataRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        UserData user= userDataRepository.findById(userId).get();
        userDataRepository.delete(user);
    }

   
    
}

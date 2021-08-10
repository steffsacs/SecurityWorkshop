package com.workshop.security.service.impl;

import com.workshop.security.model.LoginDetails;
import com.workshop.security.security.JwtTokenProvider;
import com.workshop.security.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    
    BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @Override
    public String login(LoginDetails details) throws Exception {

        System.out.println(details.getPassword()+ " before encode");
        String dao= daoData(details.getPassword());
        System.out.println(dao+ " after encode");

       if (!passwordEncoder.matches(details.getPassword(), dao)){
           throw new Exception("Login failed");
       }
       return jwtTokenProvider.createToken(details.getUser());
    }

    //This is a mock
    public  String daoData(String password){
        return passwordEncoder.encode(password);
    }
    
}

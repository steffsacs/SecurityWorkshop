package com.workshop.security.controller;

import com.workshop.security.model.LoginDetails;
import com.workshop.security.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody LoginDetails details ){
        System.out.println(details.toString());
        try{
            String l=loginService.login(details);
            return new ResponseEntity<String>(l, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }
    
    
}

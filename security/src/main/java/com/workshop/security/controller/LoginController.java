package com.workshop.security.controller;

import javax.servlet.http.HttpServletRequest;

import com.workshop.security.model.LoginDetails;
import com.workshop.security.model.Tokens;
import com.workshop.security.security.JwtTokenProvider;
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

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody LoginDetails details ){
        System.out.println(details.toString());
        try{
            Tokens l=loginService.login(details);
            return new ResponseEntity<Tokens>(l, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }


    /*@PostMapping(value="/refresh")
    public ResponseEntity<?> refresh( HttpServletRequest request ){  
        
    }*/
    
    
}

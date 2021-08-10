package com.workshop.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.workshop.security.model.Credentials;
import com.workshop.security.security.JwtTokenProvider;
import com.workshop.security.service.CredentialsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
//@RequestMapping(path="/cred")
public class CredentialsController {
    @Autowired
    CredentialsService credService;

    @Autowired
    JwtTokenProvider jwt;

    @GetMapping(value="/get/{domain}")
    public List <Credentials> get(@PathVariable("domain")String domain, HttpServletRequest request){
        String user= jwt.extractUsername(request);
        System.out.println(user);
        System.out.println(domain);
        return credService.getCredentials(domain, user) ;
    }

    @GetMapping(value="/get/hello")
    //@PreAuthorize("permitAll()")
    public String getHello( HttpServletRequest request){
        return "Hello world" ;
    }

    @GetMapping(value="/get")
    public List <Credentials> getAll(String domain, HttpServletRequest request){
        return credService.getAllCredentials();
    }

    @PostMapping(value="/post")
    public String post(){
        return null;
    }

    @DeleteMapping(value="/delete")
    public String delete(){
        return null;
    }

    @PutMapping(value="/put")
    public String put(){
        return null;
    }





    
}

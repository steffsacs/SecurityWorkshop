package com.workshop.security.service;

import java.util.List;

import com.workshop.security.model.Credentials;



public interface CredentialsService {

    List <Credentials> getAllCredentials();
    List <Credentials> getCredentials( String domain, String user);
    
    
}

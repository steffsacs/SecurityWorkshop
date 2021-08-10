package com.workshop.security.service.impl;

import java.util.List;

import com.workshop.security.model.Credentials;
import com.workshop.security.repository.CredentialsRepository;
import com.workshop.security.service.CredentialsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    CredentialsRepository credRepository ;



    @Override
    public List<Credentials> getAllCredentials() {
        return credRepository.findAll();
    }

    public List <Credentials> getCredentials( String domain, String user){
        return credRepository.findByDomainAndUser(domain, user);
    }


}

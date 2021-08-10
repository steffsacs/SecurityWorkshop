package com.workshop.security.security;

import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authenticationToken)
            throws AuthenticationException {
        // TODO Auto-generated method stub
        return  new User(username, "algo", new ArrayList<>());
    }
    
}

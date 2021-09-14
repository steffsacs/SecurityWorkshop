package com.workshop.security.service.impl;

import com.workshop.security.model.LoginDetails;
import com.workshop.security.model.Tokens;
import com.workshop.security.security.JwtTokenProvider;
import com.workshop.security.service.LoginService;
import com.workshop.security.service.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    
    BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserDataService userDataService;


    @Override
    public Tokens login(LoginDetails details) throws Exception {

        /*System.out.println(details.getPassword()+ " before encode");
        String dao= daoData(details.getPassword());
        System.out.println(dao+ " after encode");*/
        String dbPassword= userDataService.readUserByUserName(details.getUser()).getPassword();

       if (!passwordEncoder.matches(details.getPassword(), dbPassword)){
           throw new Exception("Login failed");
       }

       Tokens tokens= new Tokens();
       tokens.setAccessToken(jwtTokenProvider.createToken(details.getUser()));
       tokens.setRefreshToken(jwtTokenProvider.createRefreshToken(details.getUser()));
       return tokens; 
    }


  /*  public Tokens refreshTokens(HttpServletRequest httpRequest){
        
        String token=httpRequest.getHeader("Authorization").substring(7);
        jwtTokenProvider.extractUsername(httpRequest);  // ver que exista en db
        //checar que tenga el scope de refresh  userDataService.readUserByUserName(userName)
        //

        Tokens tokens= new Tokens();
       tokens.setAccessToken(jwtTokenProvider.createToken(details.getUser()));
       tokens.setRefreshToken(jwtTokenProvider.createRefreshToken(details.getUser()));
       return tokens; 
    }*/

    
    
}

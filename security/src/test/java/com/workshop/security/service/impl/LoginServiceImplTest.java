package com.workshop.security.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.workshop.security.security.JwtTokenProvider;
import com.workshop.security.service.UserDataService;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.workshop.security.model.LoginDetails;
import com.workshop.security.model.UserData;
import com.workshop.security.model.Tokens;


@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {


    @InjectMocks
    LoginServiceImpl loginServiceImpl;
    @Mock
    JwtTokenProvider jwtTokenProvider;
    @Mock
    UserDataService userDataService;
    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();

    //Jackson file to Java obj
    @Test
    public void loginTest(){
        UserData userData = new UserData();
        userData.setPassword(encoder.encode("password"));
        when(userDataService.readUserByUserName(anyString())).thenReturn(userData);

        when(jwtTokenProvider.createToken(anyString())).thenReturn("validToken");
        when(jwtTokenProvider.createRefreshToken(anyString())).thenReturn("validToken2");
        LoginDetails loginDetails= new LoginDetails();
        loginDetails.setPassword("password");
        loginDetails.setUser("user");
        try {
            Tokens tokens=loginServiceImpl.login(loginDetails);
            assertEquals("validToken", tokens.getAccessToken());
            assertEquals("validToken2", tokens.getRefreshToken());

        } catch (Exception e) {
            fail("Login junit failed");
        }


    }
    
}

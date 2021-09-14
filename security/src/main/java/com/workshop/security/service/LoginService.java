package com.workshop.security.service;
import com.workshop.security.model.Tokens;
import com.workshop.security.model.LoginDetails;

public interface LoginService {


     Tokens login(LoginDetails details) throws Exception;
}

package com.workshop.security.service;

import com.workshop.security.model.LoginDetails;

public interface LoginService {


     String login(LoginDetails details) throws Exception;
}

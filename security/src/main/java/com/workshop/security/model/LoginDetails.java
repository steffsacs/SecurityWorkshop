package com.workshop.security.model;

import lombok.Data;

@Data
public class LoginDetails {
    private String user;
    private String password;

    @Override
    public String toString() {
        return "LoginDetails [password=" + password + ", user=" + user + "]";
    }
   


    
}

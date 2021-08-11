package com.workshop.security.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtFilter extends BasicAuthenticationFilter{

    private JwtTokenProvider jwtTokenProvider;

    public JwtFilter(JwtTokenProvider jwt, AuthenticationManager auth){
        super(auth);
        this.jwtTokenProvider= jwt;
        
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String token= request.getHeader("Authorization");
        if(token!=null && token.startsWith("Bearer ")) token= token.substring(7);
        
        if(jwtTokenProvider.validateToken(token)){
            Authentication auth= new UsernamePasswordAuthenticationToken(jwtTokenProvider.extractUsername(request), new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);  
    }



}

package com.workshop.security.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    private String SECRET_KEY= "SteffSacs";

    //@Value("${}")
    private long expTime= 900000 ;


    public String extractUsername(HttpServletRequest httpRequest){
        String token=httpRequest.getHeader("Authorization").substring(7);
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject(); //user
    }

    public String extractId(HttpServletRequest httpRequest){
        String token = httpRequest.getHeader("Authorization").substring(7);
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getId();
    }


    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String createToken(String username){
        Claims claims= Jwts.claims().setSubject(username); // claims.put ()
        Date now= new Date();

        return Jwts.builder().setIssuer("ksquare.com").setClaims(claims).setIssuedAt(now)
        .setExpiration(new Date (now.getTime() + expTime))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
}

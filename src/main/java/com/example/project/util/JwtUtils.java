package com.example.project.util;


import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.project.common.AccessDeniedException;
import com.example.project.entity.UserLogin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
	private static long expiryDuration = 60*60;
	
	long milliTime = System.currentTimeMillis();
	long expiryTime = milliTime + expiryDuration * 1000; 
	
	Date issuedAt = new Date(milliTime);
	Date expiryAt = new Date(expiryTime);
	
	public String generatJwt(UserLogin user) {	
		Claims claims = Jwts.claims().setIssuer(user.getId().toString())
				.setIssuedAt(issuedAt)
				.setExpiration(expiryAt);
		
		claims.put("Type",user.getUserType());
		claims.put("Name",user.getName());
		claims.put("EmailId",user.getEmailId());
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	//jwt verify
	public void verify(String authorization) throws Exception {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
			
			
		}catch(Exception ex){
			throw new AccessDeniedException("Access Denied");
		}
	}

}

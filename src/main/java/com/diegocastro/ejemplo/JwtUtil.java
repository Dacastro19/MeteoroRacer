package com.diegocastro.ejemplo;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	// Generar Token y pasando al usuario por el header.	
	static void addAuthentication(HttpServletResponse resp, String username) {
		
		String token = Jwts.builder()
			.setSubject(username)
			.signWith(SignatureAlgorithm.HS512, "meteoroRacer")
			.compact();
				
		resp.addHeader("Authorization", "Bearer " + token);
	}
	
	static Authentication getAuthentication(HttpServletRequest req) {
		
		String token = req.getHeader("Authorization");
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("meteoroRacer")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}

	private static Collection<? extends GrantedAuthority> emptyList() {
		return null;
	}

}

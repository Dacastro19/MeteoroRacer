package  com.diegocastro.ejemplo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{

	public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		InputStream body = request.getInputStream();
		
		Usuarios us = new ObjectMapper().readValue(body, Usuarios.class);

		return getAuthenticationManager().authenticate(
			new UsernamePasswordAuthenticationToken(
				us.getNombre(),
				us.getPassword(),
				Collections.emptyList()
			)
		);
	}
	
	@Override
	protected void successfulAuthentication(
		HttpServletRequest req,
		HttpServletResponse resp, FilterChain chain,
		Authentication auth) throws IOException, ServletException{
		
		JwtUtil.addAuthentication(resp, auth.getName());
	}
	
}

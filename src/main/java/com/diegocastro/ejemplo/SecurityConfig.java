package com.diegocastro.ejemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.diegocastro.ejemplo.service.UsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioServiceImp userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEnconder = new BCryptPasswordEncoder();
		return bCryptPasswordEnconder;
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests()
    	.antMatchers("/login").permitAll()
    	.anyRequest().authenticated()
    	.and()
    	
    	.addFilterBefore(new LoginFilter("/login", authenticationManager()),
    			UsernamePasswordAuthenticationFilter.class)
    	.addFilterBefore(new JwtFilter(), 
    			UsernamePasswordAuthenticationFilter.class);
    }
}

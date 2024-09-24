
package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.service.LoginService;

@Configuration
@EnableWebSecurity
public class MySecurifyConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http.csrf(csrf->csrf.disable()).
			authorizeHttpRequests(httpSecurity-> {
			httpSecurity.requestMatchers("/public/**","/signup/**","/login/**").permitAll();
			httpSecurity.requestMatchers("/user/**").hasAnyRole("USER");
			httpSecurity.requestMatchers("/admin/**").hasAnyRole("ADMIN");
			httpSecurity.anyRequest().authenticated();
		}).formLogin(ll->ll.loginPage("/login").successHandler(new AuthenticationManager())).				// user defined form 
		build();									// method must be post action must be login no crsf token so disable. 
	}
	
	@Autowired
	LoginService loginService;
	
	@Bean			// retrieve user details from db 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(loginService);		
		dao.setPasswordEncoder(passwordEncoders());
		return dao;
	}
	
	@Bean
	public PasswordEncoder passwordEncoders() {
		return new BCryptPasswordEncoder();
	}
}

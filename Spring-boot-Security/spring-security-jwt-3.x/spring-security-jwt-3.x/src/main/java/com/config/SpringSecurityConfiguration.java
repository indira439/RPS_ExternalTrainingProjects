package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.service.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
	


	
	
	@Autowired
	CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
		
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.
	        csrf(csrf->csrf.disable()).
	        authorizeHttpRequests(auth-> {
	            	auth.requestMatchers("/auth/**").permitAll(); 				// Open endpoints like login, register
		            auth.requestMatchers("/admin/**").hasRole("ADMIN");
		            auth.requestMatchers("/user/**").hasRole("USER");
		            auth.anyRequest().authenticated();
	            })
	        	.exceptionHandling(exception -> exception
	                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
	                    ).sessionManagement(session -> session
	                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session creation
	                         ).addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }

}

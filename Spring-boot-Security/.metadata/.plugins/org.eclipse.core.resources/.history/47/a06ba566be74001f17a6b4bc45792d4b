package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AuthenticationRequest;
import com.bean.AuthenticationResponse;
import com.bean.Login;
import com.config.JwtUtil;
import com.service.LoginService;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private LoginService loginService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(value = "/signin")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmailid(), authenticationRequest.getPassword()));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		UserDetails userdetails = loginService.loadUserByUsername(authenticationRequest.getEmailid());
		String token = jwtUtil.generateToken(userdetails);
		return new AuthenticationResponse(token);
	}
	
	@PostMapping(value = "signup")
	public String saveUser(@RequestBody Login login) {
		if (login == null || login.getEmailid() == null) {
	        throw new IllegalArgumentException("Invalid account creation request.");
	    }
		return loginService.save(login);
	}
}

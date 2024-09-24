package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.LoginNew;
import com.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService{

	// find user details from database with role 
	// when request receive from form with action login and method as post method pre defined method called. 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(" i came in loadUserBy Method");
		Optional<LoginNew> result = loginRepository.findById(username);
		if(result.isPresent()) {
			LoginNew ll = result.get();
			String roles[] = getRoles(ll);
			for(String rr:roles) {
				System.out.println(rr);
			}
			return User.builder().username(ll.getUsername()).password(ll.getPassword()).roles(roles).build();
		}else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	
	public String[] getRoles(LoginNew login) {
		if(login.getRoles()==null) {
			return new String[] {"USER"};
		}else {
			return login.getRoles().split(",");
		}
	}
	
	@Autowired
	LoginRepository loginRepository;
	
	public String signUp(LoginNew login) {
		Optional<LoginNew> result = loginRepository.findById(login.getUsername());
		if(result.isPresent()) {
			return "Account already present";
		}else {
			loginRepository.save(login);
			return "Account created successfully";
		}
	}
}
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.LoginNew;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncode;
	
	@GetMapping(value = "login")
	public String loginPage(Model model, LoginNew login) {
		model.addAttribute("ll", login);
		System.out.println("i cam here to open login page");
		return "login";
	}
	
	@GetMapping(value = "home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping(value = "signup")
	public String singupPage(Model mm, LoginNew login) {
		mm.addAttribute("ll", login);
		System.out.println("i cam here to open signup page");
		return "signup";
	}
	@PostMapping(value = "signup")
	public String signUp(Model mm, LoginNew login) {
		login.setPassword(passwordEncode.encode(login.getPassword()));		// encode format convert 
		System.out.println(loginService.signUp(login));
		return "signup";
	}
}
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	// http://localhost:8080/
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String loginPage(Login ll,Model mm) {			// DI for Login class as well as Model object 
		mm.addAttribute("login", ll);			// request.setAttribute("key",value);
		System.out.println("login page open");
		System.out.println(ll);   // toString method called to get default value of emailid and password. 
		return "login";
	}
	
	@RequestMapping(value = "/signuppage",method = RequestMethod.GET)
	public String signUpOpen(Login ll,Model mm) {			// DI for Login class as well as Model object 
		mm.addAttribute("login", ll);			// request.setAttribute("key",value);
		System.out.println("signup page open");
		System.out.println(ll);   // toString method called to get default value of emailid and password. 
		return "signup";
	}
	
	@RequestMapping(value = "/signin",method = RequestMethod.POST)
	public String signIn(Login ll, Model mm) {
		String result = loginService.signIn(ll);
		if(result.equals("success")) {
		mm.addAttribute("emailid", ll.getEmailid());
			return "success";
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value = "/signup",method = RequestMethod.POST)
	public String signUp(Login ll, Model mm) {
		String result = loginService.signUp(ll);
		mm.addAttribute("result", result);
		return "signup";
	}

}

package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("Open Login page");
		return "login";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String checkUserDetails(HttpServletRequest req) {
		String emailId = req.getParameter("emailId");
		String password = req.getParameter("password");
		if(emailId.equals("indu@gmail.com"))
			return "success";
		else
			return "failure";
	}

}

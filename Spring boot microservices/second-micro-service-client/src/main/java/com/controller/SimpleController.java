package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value = "")
	public String welcome()
	{
		return "Welcome to second micro service project running on 8081";
	}

}

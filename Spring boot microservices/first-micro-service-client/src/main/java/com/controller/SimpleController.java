package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String sayHello()
	{
		return "Welcome to first micro service client";
	}
}

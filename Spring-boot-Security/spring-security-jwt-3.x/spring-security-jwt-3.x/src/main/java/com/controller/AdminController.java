package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

	@GetMapping(value = "")
	public String adminGreeting() {
		return "Welcome to Admin Page";
	}
}

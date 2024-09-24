package com.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String openPage() {
		System.out.println("Came here to open index.html page");
		return "index";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutPage() {
    	System.out.println("About Page");
    	return "About";
    }
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage() {
    	System.out.println("Contact Page");
    	return "contact";
    }

}

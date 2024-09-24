package com.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Enrollment;

@RestController
public class EnrollmentController {
	
	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public String enroll(@RequestBody Enrollment enr)
	{
		return "";
	}

}

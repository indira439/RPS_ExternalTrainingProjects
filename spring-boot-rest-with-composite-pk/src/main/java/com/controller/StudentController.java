package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Students;
import com.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentSrvc;
	
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public String storeStudent(@RequestBody Students student) {
		System.out.println("Store student controller");
		return studentSrvc.storeStudent(student);
	}
	
	@RequestMapping(value = "students",
			method = RequestMethod.GET)
	public List<Students> findAll() {
		return studentSrvc.findAll();
	}
	
	@RequestMapping(value = "deletestudent/{sid}",
			method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("sid") int sid) {
		return studentSrvc.deleteStudent(sid);
	}

}

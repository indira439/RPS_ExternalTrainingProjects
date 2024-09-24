package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.exception.CustomException;

@RestController
public class EmployeeController {

	@GetMapping(value = "nullpointer/{id}")
	public String getEmpInfo(@PathVariable("id") int id) {
		if(id>10) {
			Employee emp = new Employee();
			return emp.sayHello();
		}else {
			Employee emp=null;
			return emp.sayHello();
		}
	}
	
	@GetMapping(value = "custom/{salary}")
	public String customException(@PathVariable("salary") float salary) throws Exception{
		if(salary>25000) {
			return "Your information stored in db";
		}else {
			throw new CustomException("salary must be > 25000");
		}
	}
}

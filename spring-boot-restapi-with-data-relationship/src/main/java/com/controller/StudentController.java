package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	// http://localhost:8080/students
	
	@RequestMapping(value = "students",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@RequestMapping(value = "storestudent",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Student student) {
		return studentService.storeStudent(student);
	}
	
	@RequestMapping(value = "updatestudent",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudentAge(student);
	}
	
	@RequestMapping(value = "deletestudent/{sid}",
			method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("sid") int sid) {
		return studentService.deleteStudent(sid);
	}
	
	
	
	@RequestMapping(value = "deletestudentbyage/{age}",
			method = RequestMethod.DELETE)
	public String deleteStudentByAge(@PathVariable("age") int age) {
		return studentService.deleteStudentByAge(age);
	}
}
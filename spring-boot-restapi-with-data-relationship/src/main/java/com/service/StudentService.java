package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	@Transactional
	public String deleteStudentByAge(int age) {
		if(studentRepository.deleteStudentById(age)>0) {
			return "Student record deleted";
		}else {
			return "Student record not present";
		}

	}

	public String storeStudent(Student student) {
		Optional<Student> result = studentRepository.findById(student.getSid());
		if(result.isPresent()) {
			return "SId must be unique";
		}else {
			studentRepository.save(student);
			return "Student Record stored successfuly";
		}
	}
	
	public String deleteStudent(int sid) {
		Optional<Student> result = studentRepository.findById(sid);
		if(result.isPresent()) {
			studentRepository.deleteById(sid);
			return "Student record deleted successfully";
		}else {
			return "Student record not present";
		}
	}
	
	public String updateStudentAge(Student student) {
		Optional<Student> result = studentRepository.findById(student.getSid());
		if(result.isPresent()) {
			Student s = result.get();
			s.setAge(student.getAge());
			studentRepository.saveAndFlush(s);
			return "Student age updated successfully";
		}else {
			return "Student record not present";
		}
	}
	
	
}
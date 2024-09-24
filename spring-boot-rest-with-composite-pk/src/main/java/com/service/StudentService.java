package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Students;
import com.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	public String storeStudent(Students student) {
		// TODO Auto-generated method stub
		System.out.println("Store student service layer");
		studentRepo.save(student);
		return "Student record saved successfully";
	}

	public List<Students> findAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	public String deleteStudent(int sid) {
		Optional<Students> result = studentRepo.findById(sid);
		if(result.isPresent()) {
			studentRepo.deleteById(sid);
			return "Student record deleted successfully";
		}else {
			return "Student record not present";
		}
	}

}

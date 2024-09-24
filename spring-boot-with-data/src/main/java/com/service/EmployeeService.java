package com.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.Employee;
import com.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public String storeEmployee(Employee employee) {
		
		Optional<Employee> result =  employeeRepository.findById(employee.geteID());
		if(result.isPresent()) {
			return "Employee id must be unqiue";
		}else {
			employeeRepository.save(employee);
			return "Employee record stored";
		}
		
	}
	
	public List<Employee> findAllEmployees() {
					return employeeRepository.findAll();
	}
	
	public String deleteEmployeeById(int eid) {
		
		//employeeRepository.deleteById(eid);
		
		Optional<Employee> result =  employeeRepository.findById(eid);
		if(result.isPresent()) {
			Employee emp = result.get();
			employeeRepository.delete(emp);
			return "Employee record deleted";
		}else {
			return "Record not present";
		}
	}
	public String updateEmployeeById(Employee emp) {
		Optional<Employee> result =  employeeRepository.findById(emp.geteID());
		if(result.isPresent()) {
			Employee employee = result.get();
			employee.setSalary(emp.getSalary());
			employeeRepository.saveAndFlush(employee);
			return "Employee salary updated successfully";
		}else {
			return "Record not present";
		}
	}
	public String findEmployee(int eid) {
		Optional<Employee> result =  employeeRepository.findById(eid);
		if(result.isPresent()) {
			Employee emp = result.get();
			return emp.toString();
		}else {
			return "Record not present";
		}
	}
	
	public Employee findEmployeeById(int eid) {
		Optional<Employee> result =  employeeRepository.findById(eid);
		if(result.isPresent()) {
			Employee emp = result.get();
			return emp;
		}else {
			return null;
		}
	}
}
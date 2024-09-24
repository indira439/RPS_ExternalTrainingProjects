package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Employee;
import com.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	// http://localhost:9090/
		@RequestMapping(value = "/",method = RequestMethod.GET)
		public String openIndexPage(Model model,Employee employee) {   // DI
			
			List<Employee> listOfEmployee = employeeService.findAllEmployees();
			model.addAttribute("listofemployee", listOfEmployee);
			model.addAttribute("emp", employee);
			model.addAttribute("buttonValue", "Store Employee");
			model.addAttribute("readonly", false);
			return "index";
		}
		
		@RequestMapping(value = "/storeemployee",method = RequestMethod.POST)
		public String storeEmployee(Model model,Employee employee,HttpServletRequest req) {   // DI
			String result = "";
			String butonValue = req.getParameter("submitButton");
			System.out.println(butonValue);	

			if(butonValue.equals("Store Employee")) {
				result = employeeService.storeEmployee(employee);
				model.addAttribute("buttonValue", "Store Employee");
				System.out.println(result);	
			}else {
				System.out.println("else store");	

				result = employeeService.updateEmployeeById(employee);
				model.addAttribute("buttonValue", "Store Employee");
			}
			List<Employee> listOfEmployee = employeeService.findAllEmployees();
			model.addAttribute("listofemployee", listOfEmployee);
			model.addAttribute("msg", result);
				employee.seteID(0);
				employee.seteName("");
				employee.setSalary(0.0f);
			model.addAttribute("emp", employee);
			return "index";
		}
		@RequestMapping(value = "/deleteemployee",method = RequestMethod.GET)
		public String deleteEmployee(Model model,Employee employee,HttpServletRequest req) {
			int eid = Integer.parseInt(req.getParameter("eid"));
			//System.out.println("id is "+eid);
			String result = employeeService.deleteEmployeeById(eid);
			model.addAttribute("msg", result);
			List<Employee> listOfEmployee = employeeService.findAllEmployees();
			model.addAttribute("listofemployee", listOfEmployee);
			employee.seteID(0);
			employee.seteName("");
			employee.setSalary(0.0f);
			model.addAttribute("buttonValue", "Store Employee");
			model.addAttribute("emp", employee);
			return "index";
		}
		
		@RequestMapping(value = "/updateemployee",method = RequestMethod.GET)
		public String updateEmployee(Model model,HttpServletRequest req) {
			int eid = Integer.parseInt(req.getParameter("eID"));
			Employee employee = employeeService.findEmployeeById(eid);
			System.out.println(employee);
			List<Employee> listOfEmployee = employeeService.findAllEmployees();
			model.addAttribute("listofemployee", listOfEmployee);
			model.addAttribute("emp", employee);
			model.addAttribute("buttonValue", "Update Employee");
			model.addAttribute("readonly", true);
			return "index";
		}
}

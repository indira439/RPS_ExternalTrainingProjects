package com.userobject;

import java.io.Serializable;

public class Employee implements Serializable{
	
	public Employee()
	{
		
	}

	public Employee(int age, String fname)
	{
		this.age = age;
		this.fname = fname;
	}
	
	private int age;
	private String fname;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "Employee [age=" + age + ", fname=" + fname + "]";
	}
	
	
}

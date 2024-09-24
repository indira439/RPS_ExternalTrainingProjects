
package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component                           // <bean class="com.Employee"></bean>
public class Employee {           // id name is employee  
//@Value(value= "100")
private int id; 
@Value(value = "indu")
private String name;
@Value(value = "10000")
private float salary;
@Autowired
private Address add;
	public Employee() {
		System.out.println("object created...");
		this.id = 6;
	}
	
	public Employee(int id, String name, float salary) {
		super();
		System.out.println("object created using parameter");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, float salary, Address add) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.add = add;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public void display() {
		System.out.println("Employee class method");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", add=" + add + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}

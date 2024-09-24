package encapsulation;

import java.io.*;

public class Employye {
	
	private int id;
	private String name;
	private float salary;

	public Employye() {
		// TODO Auto-generated constructor stub
		this.id = 1;
		this.name ="Indu";
		this.salary = 10000;
		System.out.println("Constructor is called");
		System.out.println(id + "-" + name + "-" + salary);
	}
	
	public Employye(int id, String name, float sal)
	{
		this.id = id;
		this.name = name;
		this.salary = sal;
		System.out.println("Parameterized Constructor is called");
		System.out.println(id + "-" + name + "-" + salary);
	}
	
	private int getID() {
		return this.id;
	}

	private String getName() {
		return this.name;
	}
	
	private float getSalary() {
		return this.salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	

}

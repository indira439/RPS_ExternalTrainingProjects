package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {

	public static void main(String[] args) throws Exception {
		//COPYFROM ONE FILE TO OTHER.
		FileInputStream fis = new FileInputStream("src\\com\\abc.txt");
		FileOutputStream fos = new FileOutputStream("Info.txt");
		int ch;
		
		while((ch=fis.read())!=-1)
		{
			fos.write(ch);
		}
		
		fis.close();
		fos.close();
		
		System.out.println("File copied");
		
		
		// if we want to store primitive data in file 
		int id=200;
		String name = "Ravi";
		float salary = 12000;
		
		FileOutputStream fos1 = new FileOutputStream("emp.txt");
		DataOutputStream dos = new DataOutputStream(fos1);
		dos.writeInt(id);
		dos.writeUTF(name);
		dos.writeFloat(salary);
		dos.close();
		fos1.close();
		System.out.println("employee data stored as primitive value");
		
		// read employee primitive information 
		FileInputStream fis1 =new FileInputStream("emp.txt");
		DataInputStream dis = new DataInputStream(fis1);
		int id1= dis.readInt();
		String name1 = dis.readUTF();
		float salary1 = dis.readFloat();
		System.out.println("id is "+id1);
		System.out.println("name is "+name1);
		System.out.println("salary is "+salary1);
		
		Employee emp = new Employee(100, "Ravi", 12000);
		System.out.println(emp);
		FileOutputStream fos2 = new FileOutputStream("employee.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos2);
		oos.writeObject(emp);
		oos.close();
		System.out.println("object serialization done!");
		
		FileInputStream fis3 = new FileInputStream("employee.ser");
		ObjectInputStream ois = new ObjectInputStream(fis3);
		Object obj = ois.readObject();
		Employee emp01 = (Employee)obj;
		System.out.println(emp01);
		
		// storing list of object 
		
		Employee emp1 = new Employee(100, "Ravi", 12000);
		Employee emp2 = new Employee(100, "Ravi", 12000);
		Employee emp3 = new Employee(100, "Ravi", 12000);
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		FileOutputStream fos4 = new FileOutputStream("employees.ser");
		ObjectOutputStream oos4 = new ObjectOutputStream(fos4);
		oos4.writeObject(listOfEmp);
		oos4.close();
		System.out.println("object serialization done!");
		
		FileInputStream fis5 = new FileInputStream("employees.ser");
		ObjectInputStream ois5 = new ObjectInputStream(fis5);
		Object obj5 = ois5.readObject();
		List<Employee> listofemployees = (List<Employee>)obj5;
		System.out.println(listOfEmp.size());

	}

}

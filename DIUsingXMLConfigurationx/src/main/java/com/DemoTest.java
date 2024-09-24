
package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
//		Employee emp = new Employee();
//		emp.display();
		Resource res = new ClassPathResource("beans.xml");  // load the file get the resource reference
		BeanFactory obj = new XmlBeanFactory(res);	// get the BeanFactory reference. 
		
//		Employee emp1 = (Employee)obj.getBean("emp1");
//		emp1.display();
//		
//		Employee emp3 = (Employee)obj.getBean("emp1");
//		emp3.display();
//		
//		Employee emp2 = (Employee)obj.getBean("emp2");
//		emp2.display();
//		
//		Employee emp4 = (Employee)obj.getBean("emp2");
//		emp4.display();
//		
//		Employee emp1 = (Employee)obj.getBean("emp1");
//		System.out.println(emp1);
//		Employee emp2 = (Employee)obj.getBean("emp2");
//		System.out.println(emp2);
//		
//		Employee emp3 = (Employee)obj.getBean("emp3");
//		System.out.println(emp3);
//		
//		Employee emp4 = (Employee)obj.getBean("emp4");
//		System.out.println(emp4);
		
//		Address add1 = (Address)obj.getBean("address");
//		System.out.println(add1);
		
		Employee emp1 = (Employee)obj.getBean("emp1");
		System.out.println(emp1);
	}

}

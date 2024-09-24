
package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {

//		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
//		Employee emp = (Employee) ap.getBean("employee");
//		System.out.println(emp);
//		emp.setId(100);
//		emp.setName("Ravi");
//		emp.setSalary(34000);
//		System.out.println(emp);
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println(emp);
		emp.setId(100);
		emp.setName("Ravi");
		emp.setSalary(34000);
		System.out.println(emp);
		
		Address add = (Address)ac.getBean("address");
		System.out.println(add);
	}
}

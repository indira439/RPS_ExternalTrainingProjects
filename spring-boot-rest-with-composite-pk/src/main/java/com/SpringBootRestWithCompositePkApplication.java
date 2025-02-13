package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
public class SpringBootRestWithCompositePkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestWithCompositePkApplication.class, args);
		System.out.println("Composite-Pk application is up");
	}

}

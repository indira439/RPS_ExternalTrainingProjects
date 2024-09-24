package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com")
@EnableCaching
public class SpringBootWithRedisDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithRedisDemoAppApplication.class, args);
		System.out.println("redis spring boot up!");
	}

}

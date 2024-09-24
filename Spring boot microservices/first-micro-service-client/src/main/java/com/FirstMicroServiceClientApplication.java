package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class FirstMicroServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMicroServiceClientApplication.class, args);
		System.out.println("First micro service client app on 8080 is up");
	}

}

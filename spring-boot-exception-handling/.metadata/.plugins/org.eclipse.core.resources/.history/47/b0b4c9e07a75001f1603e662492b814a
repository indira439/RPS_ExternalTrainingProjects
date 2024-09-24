package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalExceptionHandling {

	@GetMapping(value = "divided/{num}")
	public String dividedByZero(@PathVariable("num") int num) {
		int result = 100/num;
		return "Result is "+result;
	}
	
	@GetMapping(value = "array/{index}")
	public String arrayIndex(@PathVariable("index") int index) {
		int info[]= {100,200,300,400};
		return "Array value base upon index position "+info[index];
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exp){
		return ResponseEntity.status(500).body("Exception generated "+exp);
	}
}
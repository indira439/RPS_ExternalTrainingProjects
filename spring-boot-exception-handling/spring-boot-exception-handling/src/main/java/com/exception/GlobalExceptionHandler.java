package com.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> arithmeticEx(ArithmeticException exp)
	{
		return ResponseEntity.status(500).body("Arithemtic exception generated " + exp);
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<String> indexOutExcp(ArrayIndexOutOfBoundsException exp)
	{
		return ResponseEntity.status(500).body("Array Index Out Of Bound exception generated - " + exp);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> customExceptn(CustomException exp)
	{
		return ResponseEntity.status(500).body("Custome exception generated - " + exp);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalException(Exception exp)
	{
		return ResponseEntity.status(500).body("Generic exception generated " + exp);
	}
	
}

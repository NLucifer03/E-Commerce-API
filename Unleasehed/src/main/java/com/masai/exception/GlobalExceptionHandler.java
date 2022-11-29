package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
//	------------------------Product Exception---------------------------------------
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> productExceptionHandler(Exception exception, WebRequest webRequest)
	{
		MyError error = new MyError(exception.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return  new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
//	-----------------------------------cart Exception handler------------------------
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyError> cartExceptionHandler(CartException cartException, WebRequest webRequest)
	{
		MyError error = new MyError(cartException.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return  new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
//	------------------------------------customer Exception Handler--------------------
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> CustomerExceptionHandler(CustomerException customerException, WebRequest webRequest)
	{
		MyError error = new MyError(customerException.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return  new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
//	------------------------------------orders Exception handler-----------------------
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyError> orderExceptionHandler(OrdersException ordersException, WebRequest webRequest)
	{
		MyError error = new MyError(ordersException.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return  new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
}

package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

//		--------injection customer Service dependency---------
	@Autowired
	CustomerService customerService;

//	------------------------ add customers handler------------------------------------
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException, CartException
	{	
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
//	------------------------- update customers handler --------------------------------
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer) throws CustomerException
	{	
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.OK);
	}
	
//	----------------------------get customers by id handler ------------------------------
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable Integer customerId) throws CustomerException
	{	
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
//	-----------------------------delete customers by product id handler --------------------
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer customerId) throws CustomerException
	{	
		return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId),HttpStatus.OK);
	}
	
//	--------------------------------get all customers handler------------------------------
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomerHandler() throws CustomerException
	{	
		return new ResponseEntity<List<Customer>>(customerService.viewAllCustomers(),HttpStatus.OK);
	}
	
	
}

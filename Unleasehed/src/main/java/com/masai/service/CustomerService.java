package com.masai.service;

import java.util.List;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {

//	--------------------------------------creating Customer------------------------------------------------------------
	public Customer addCustomer(Customer customer) throws CustomerException, CartException ;
	
//	---------------------------------------------delete customer Account----------------------------------------------
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
//	--------------------------------------------update customer Account------------------------------------------------
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
//	---------------------------------------------getCustomer Account---------------------------------------------------
	public Customer getCustomerById(Integer customerId) throws CustomerException;

//	----------------------------------------------view All Customers----------------------------------------------------
	public List<Customer> viewAllCustomers() throws CustomerException;
	
	
	
	
}

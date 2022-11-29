package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service

public class CustomerServiceImpl implements CustomerService{

	
//	----------------injecting customerReposityr interface---------------
	@Autowired
	CustomerRepository customerRepository;
	
//	----------------------------------------------------------------adding customer into database-------------------------------------------------------------
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException, CartException {
		
		if(customer.getCustomerId() != null) throw new CustomerException("customer Id is not required...");
		
		if(customer.getCart() == null) throw new CartException("Cart is required for create customer. Please provide cart Details also");
		if(customer.getCart().getCartId() != null) throw new CartException("Cart Id is not Required..");
		Cart cart = customer.getCart();
		cart.setCustomer(customer);
		
		Customer saveCustomer = customerRepository.save(customer);
		if(saveCustomer == null) throw new CustomerException("Failed to register customer details into database");
		return saveCustomer;
		
	}

//	----------------------------------------------------------------------deleting customer by customer id----------------------------------------------------
	
	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {
		
		Customer customer = customerRepository.findById(customerId)
							.orElseThrow(() -> new CustomerException("Please provide valid customer Id..."));
		
		customerRepository.delete(customer);
		return customer;
		
	}
	
//	----------------------------------------------------------------------updating customer by customer object-------------------------------------------------

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		
		customerRepository.findById(customer.getCustomerId())
		.orElseThrow(() -> new CustomerException("Please provide valid customer Id..."));
		
		return customerRepository.save(customer);
		
	}

//	------------------------------------------------------------------------get customer by customer id-------------------------------------------------------	

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {

		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Please provide valid customer Id..."));
		
	}

//	--------------------------------------------------------------------------view all customer from database--------------------------------------------------
	
	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		
		List<Customer> customers = customerRepository.findAll();
		
		if(customers.size() == 0) throw new CustomerException("No customer is registered into the database");
		return customers;
		
	}

}

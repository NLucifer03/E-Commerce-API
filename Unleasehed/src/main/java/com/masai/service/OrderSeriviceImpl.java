package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CustomerException;
import com.masai.exception.OrdersException;
import com.masai.exception.ProductException;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.repository.CustomerRepository;
import com.masai.repository.OrdersRepository;
import com.masai.repository.ProductRepository;

public class OrderSeriviceImpl implements OrderService{

//	injecting the dependencies of OrderRepository, custoerRepositry and product Repository
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	

//	--------------------------------------------making am order---------------------------------------
	
	@Override
	public Orders placeOrder(Integer productId,Integer CustomerId) throws OrdersException, ProductException, CustomerException {
		
		Product product  = productRepository.findById(productId)
							.orElseThrow(()-> new ProductException("Invalid productId...."));
		
		Customer customer = customerRepository.findById(CustomerId)
							.orElseThrow(()-> new CustomerException("Invlaid CustomerId...."));
		
		
		Orders orders = new Orders(product, customer);
		
		customer.getOrders().add(orders);
		product.getOrders().add(orders);
		
		Orders saveOrder = ordersRepository.save(orders);
		
		if(saveOrder == null) throw new OrdersException("Failed to place an order");
		return saveOrder;
		

	}

//	--------------------------------------------delete an order--------------------------------------
	
	@Override
	public Orders deleteOrder(Integer orderId) throws OrdersException {
		
		Orders order = ordersRepository.findById(orderId).orElseThrow(() -> new OrdersException("Invalid Order Id"));
		ordersRepository.delete(order);
		return order;
		
	}

//	--------------------------------------------view list of all orders-------------------------------
	
	@Override
	public List<Orders> viewListOfOrders() throws OrdersException {
		
		List<Orders> orders = ordersRepository.findAll();
		
		if(orders.size() == 0) throw new OrdersException("No order is placed yet........");
		
		return orders;
		
	}
	
//	----------------------------------------------Find order by order Id-----------------------------

	@Override
	public Orders findOrderById(Integer orderId) throws OrdersException {
		
		return ordersRepository.findById(orderId)
				.orElseThrow(() -> new OrdersException("Invalid Order Id"));
		
	}

}

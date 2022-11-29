package com.masai.controller;

import java.util.List;

import javax.persistence.criteria.Order;

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
import com.masai.exception.OrdersException;
import com.masai.exception.ProductException;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
public class OrderController {

//	injecting order service
	OrderService orderServie;
	
//	------------------------ placing order handler------------------------------------
	
	@PostMapping("/orders/{productId}/{customerId}")
	public ResponseEntity<Orders> placeOrderHandler(@PathVariable Integer productId, @PathVariable Integer customerId) throws CustomerException, ProductException, OrdersException
	{	
		return new ResponseEntity<Orders>(orderServie.placeOrder(productId,customerId),HttpStatus.CREATED);
	}
	
//	------------------------- update product handler --------------------------------
	
	
//	----------------------------get product by id handler ------------------------------
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> getOrderByIdHandler(@PathVariable Integer orderId) throws OrdersException
	{	
		return new ResponseEntity<Orders>(orderServie.findOrderById(orderId),HttpStatus.OK);
	}
	
//	-----------------------------delete product by product id handler --------------------
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Orders> deleteOrderHandler(@PathVariable Integer orderId) throws OrdersException
	{	
		return new ResponseEntity<Orders>(orderServie.deleteOrder(orderId),HttpStatus.OK);
	}
	
//	--------------------------------get all product handler------------------------------
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> viewAllOrdersHandler() throws OrdersException
	{	
		return new ResponseEntity<List<Orders>>(orderServie.viewListOfOrders(),HttpStatus.OK);
	}
	
	
	
	
}

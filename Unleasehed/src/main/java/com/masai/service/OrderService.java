package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.OrdersException;
import com.masai.exception.ProductException;
import com.masai.model.Orders;

public interface OrderService {

//	--------------------------------place order------------------------------------
	public Orders placeOrder(Integer productId,Integer CustomerId) throws OrdersException, ProductException, CustomerException;
	
	
//	---------------------------------delete order----------------------------------
	public Orders deleteOrder(Integer orderId) throws OrdersException;
	
//	----------------------------------view orders----------------------------------
	public List<Orders> viewListOfOrders() throws  OrdersException;
	
	
//	---------------------------------view order by orderId------------------------
	public Orders findOrderById(Integer orderId) throws OrdersException;
	
}

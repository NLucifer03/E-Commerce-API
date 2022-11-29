package com.masai.service;

import java.util.List;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;

public interface ProductService {

//	-----------creating products ------------------------------------------------------
	public Product createProduct(Product product) throws ProductException;
	
//	------------get product by product Id----------------------------------------------
	public Product getProductById(Integer productId) throws ProductException;
	
//	-------------------------delete product by product Id------------------------------
	public Product deleteProduct(Integer ProductId) throws ProductException;
	
//	-------------------------------get all products in list----------------------------
	public List<Product> getAllProducts() throws ProductException;
	
//	----------------------------------updating product---------------------------------
	public Product updateProduct(Product product) throws ProductException;
	
//	---------------------------------add Product into cart-----------------------------
	public Cart addProductIntoCart(Integer productId,Integer cartId) throws ProductException, CartException;
	
	
}

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
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class ProductController {
	
//	--------injection productService dependency---------
	@Autowired
	ProductService productService;

//	------------------------ add product handler------------------------------------
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product) throws ProductException
	{	
		return new ResponseEntity<Product>(productService.createProduct(product),HttpStatus.CREATED);
	}
	
//	------------------------- update product handler --------------------------------
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductException
	{	
		return new ResponseEntity<Product>(productService.updateProduct(product),HttpStatus.OK);
	}
	
//	----------------------------get product by id handler ------------------------------
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProductByIdHandler(@PathVariable Integer productId) throws ProductException
	{	
		return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	
//	-----------------------------delete product by product id handler --------------------
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable Integer productId) throws ProductException
	{	
		return new ResponseEntity<Product>(productService.deleteProduct(productId),HttpStatus.OK);
	}
	
//	--------------------------------get all product handler------------------------------
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProductHandler() throws ProductException
	{	
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
//	------------------------------------adding product into cart-------------------------
	
	@PostMapping("/products/{productId}/{cartId}")
	public ResponseEntity<Cart> deleteProductHandler(@PathVariable Integer productId, @PathVariable Integer cartId) throws ProductException, CartException
	{	
		return new ResponseEntity<Cart>(productService.addProductIntoCart(productId,cartId),HttpStatus.OK);
	}
	
	
	
}

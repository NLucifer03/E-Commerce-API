package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.repository.CartRepository;
import com.masai.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

//	---------------injecting productRepo interface and cartRepo interface------------------
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	
	
	
//	--------------------------------------------------------creating Product---------------------------------------------------------
	
	@Override
	public Product createProduct(Product product) throws ProductException {
		
		if(product.getProductId() != null) throw new ProductException("product id is not required....");
		Product saveProduct = productRepository.save(product);
		if(saveProduct == null) throw new ProductException("failed to add product into database.....");
		return product;
		
	}
	
//	------------------------------------------------------get product by product Id--------------------------------------------------

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		
		return productRepository.findById(productId)
							.orElseThrow(() -> new ProductException("Product Id is not valid"));
		
	}
	
//	--------------------------------------------------------delete product by product id---------------------------------------------

	@Override
	public Product deleteProduct(Integer productId) throws ProductException {
		
		Product product = productRepository.findById(productId)
							.orElseThrow(() -> new ProductException("Product Id is not valid"));
		
		productRepository.delete(product);
		
		return product;
		
	}

//	--------------------------------------------------------get all  products from database------------------------------------------
	
	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> products = productRepository.findAll();
		if(products.size() == 0) throw new ProductException("No Product is available in database......");
	
		return products;
		
	}
	
//	----------------------------------------------------------update product by product object----------------------------------------

	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		productRepository.findById(product.getProductId())
					.orElseThrow(() -> new ProductException("Product Id is not valid"));
		
		productRepository.save(product);
		return product;
		
	}

//	-------------------------------------------------------add product into the cart--------------------------------------------------
	
	@Override
	public Cart addProductIntoCart(Integer productId, Integer cartId) throws ProductException, CartException {
		
		Product product = productRepository.findById(productId)
							.orElseThrow(() -> new ProductException("Product Id is not valid"));
		
		Cart cart = cartRepository.findById(cartId)
					.orElseThrow(()-> new CartException("Cart id is not valid...."));
		
		product.getCarts().add(cart);
		cart.getProducts().add(product);
		
		cartRepository.save(cart);
		
		return cart;
	
	
	
	}

}

package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String category;
	private Integer quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetails productDescription;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cart> carts = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();
	
	
}

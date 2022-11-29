package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer ordersId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public Orders(Product product, Customer customer) {
		super();
		this.product = product;
		this.customer = customer;
	}
	
	
	
	
}

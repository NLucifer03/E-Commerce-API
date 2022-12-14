package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer produtDetailsId;
	private String productDescription;
	
}

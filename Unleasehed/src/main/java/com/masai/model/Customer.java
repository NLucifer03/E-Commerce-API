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
@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String city;
	private String country;
	private String state;
	private Integer pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	List<Orders> orders = new ArrayList<>();
	
}

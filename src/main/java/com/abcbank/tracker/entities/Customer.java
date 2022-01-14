package com.abcbank.tracker.entities;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	
	public Customer(int customerId, String firstName, String lastName, String emailId) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
	int customerId;
	String firstName;
	String lastName;
	String emailId;
	List<Account> accountsList;
}

package com.abcbank.tracker.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abcbank.tracker.entities.Customer;

@Component
public class CustomerDaoImpl implements CustomerDAO {
	
	private static List<Customer> customerList = new ArrayList<Customer>();
	static int customerId = 0;
	static {
		
		Customer customer1 = new Customer(++customerId, "Raja", "Kumar", "raja.kumar@gmail.com");
		Customer customer2 = new Customer(++customerId, "Vanaja", "Kumari", "vanaja.kumari@gmail.com");
		Customer customer3 = new Customer(++customerId, "Ranjan", "Mayank", "ranjan.mayank@gmail.com");
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
	}

	@Override
	public Customer getCustomerDetails(int customerId) {
		Customer customerDetails = null;
		for(Customer customer : customerList) {
			if(customer.getCustomerId() == customerId) {
				customerDetails = customer;
				break;
			}
		}
		return customerDetails;
	}

	@Override
	public List<Customer> getCustomerList() {
		return customerList;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(++customerId);
		customerList.add(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customerData) {
		Customer updatedCustomer = null;
		for(Customer customer : customerList) {
			if(customer.getCustomerId() == customerId) {
				updatedCustomer = customerData;
				customer.setCustomerId(customerId);
				customer.setFirstName(customerData.getFirstName());
				customer.setLastName(customerData.getLastName());
				customer.setEmailId(customerData.getEmailId());
				break;
			}
		}
		return updatedCustomer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer deletedCustomer = null;
		Iterator<Customer> iter = customerList.iterator();
		while(iter.hasNext()) {
			Customer customer = iter.next();
			if(customerId == customer.getCustomerId()) {
				deletedCustomer = customer;
				iter.remove();
			}
		}
		return deletedCustomer;
	}
	
}

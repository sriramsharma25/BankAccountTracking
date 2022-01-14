package com.abcbank.tracker.dao;

import java.util.List;

import com.abcbank.tracker.entities.Customer;

public interface CustomerDAO {

	public Customer getCustomerDetails(int customerId);
	public List<Customer> getCustomerList();
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(int customerId, Customer customer);
	public Customer deleteCustomer(int customerId);
}

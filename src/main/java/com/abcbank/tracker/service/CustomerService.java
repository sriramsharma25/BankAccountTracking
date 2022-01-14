package com.abcbank.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.tracker.dao.CustomerDAO;
import com.abcbank.tracker.entities.Customer;

@Service
public class CustomerService {

		@Autowired
		CustomerDAO customerDao;
		
		public List<Customer> getCustomerList() {
			return customerDao.getCustomerList();
		}
		
		public Customer getCustomer(int customerId) {
			return customerDao.getCustomerDetails(customerId);
		}
		
		public Customer createCustomer(Customer customer) {
			return customerDao.createCustomer(customer);
		}
		
		public Customer updateCustomer(int customerId, Customer customer) {
			return customerDao.updateCustomer(customerId, customer);
		}
		
		public Customer deleteCustomer(int customerId) {
			return customerDao.deleteCustomer(customerId);
		}
}

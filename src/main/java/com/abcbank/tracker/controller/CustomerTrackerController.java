package com.abcbank.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.tracker.entities.Account;
import com.abcbank.tracker.entities.Customer;
import com.abcbank.tracker.exception.NotFoundException;
import com.abcbank.tracker.service.AccountService;
import com.abcbank.tracker.service.CustomerService;

@RestController
public class CustomerTrackerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomerList() {
		
		List<Customer> customersList = customerService.getCustomerList();
		if(customersList == null || customersList.size() == 0) {
			throw new NotFoundException("No Customer available");
		}
		return customersList;
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new NotFoundException("Customer "+ customerId + " Not available");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		return createdCustomer;
	}
	
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
		Customer createdCustomer = customerService.updateCustomer(customerId, customer);
		return createdCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer deletedCustomer = customerService.deleteCustomer(customerId);
		return deletedCustomer;
	}
	
	@GetMapping("/accounts")
	public List<Account> getAccountList() {
		
		List<Account> accountsList = accountService.getAccountList();
		if(accountsList == null || accountsList.size() == 0) {
			throw new NotFoundException("No Account available");
		}
		return accountsList;
	}
	
	@GetMapping("/accounts/{accountId}")
	public Account getAccount(@PathVariable int accountId) {
		Account account = accountService.getAccount(accountId);
		if(account == null) {
			throw new NotFoundException("Account "+ accountId + " Not available");
		}
		return account;
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		Account createdAccount = accountService.createAccount(account);
		return createdAccount;
	}
	
	@PutMapping("/accounts/{accountId}")
	public Account updateAccount(@PathVariable int accountId, @RequestBody Account account) {
		Account createdAccount = accountService.updateAccount(accountId, account);
		return createdAccount;
	}
	
	@DeleteMapping("/accounts/{accountId}")
	public Account deleteAccount(@PathVariable int accountId) {
		Account deletedAccount = accountService.deleteAccount(accountId);
		return deletedAccount;
	}
}

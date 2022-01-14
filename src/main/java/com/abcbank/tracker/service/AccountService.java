package com.abcbank.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.tracker.dao.AccountDAO;
import com.abcbank.tracker.entities.Account;

@Service
public class AccountService {

	@Autowired
	AccountDAO accountDao;
	
	public List<Account> getAccountList() {
		return accountDao.getAccountList();
	}
	
	public Account getAccount(int accountId) {
		return accountDao.getAccountDetails(accountId);
	}
	
	public Account createAccount(Account account) {
		return accountDao.createAccount(account);
	}
	
	public Account updateAccount(int accountId, Account account) {
		return accountDao.updateAccount(accountId, account);
	}
	
	public Account deleteAccount(int accountId) {
		return accountDao.deleteAccount(accountId);
	}
}

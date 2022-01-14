package com.abcbank.tracker.dao;

import java.util.List;

import com.abcbank.tracker.entities.Account;

public interface AccountDAO {

	public Account getAccountDetails(int accountId);
	public List<Account> getAccountList();
	public Account createAccount(Account account);
	public Account updateAccount(int accountId, Account account);
	public Account deleteAccount(int accountId);
}

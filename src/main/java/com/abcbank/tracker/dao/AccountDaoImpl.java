package com.abcbank.tracker.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abcbank.tracker.entities.Account;

@Component
public class AccountDaoImpl implements AccountDAO {
	
	private static List<Account> accountList = new ArrayList<Account>();
	static int accountId = 0;
	static {
		
		Account account1 = new Account(++accountId, "Savings", 10000);
		Account account2 = new Account(++accountId, "Current", 75000);
		Account account3 = new Account(++accountId, "Capital", 87500000);
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
	}

	@Override
	public Account getAccountDetails(int accountId) {
		Account accountDetails = null;
		for(Account account : accountList) {
			if(account.getAccountId() == accountId) {
				accountDetails = account;
				break;
			}
		}
		return accountDetails;
	}

	@Override
	public List<Account> getAccountList() {
		return accountList;
	}

	@Override
	public Account createAccount(Account account) {
		account.setAccountId(++accountId);
		accountList.add(account);
		return account;
	}

	@Override
	public Account updateAccount(int accountId, Account accountData) {
		Account updatedAccount = null;
		for(Account account : accountList) {
			if(account.getAccountId() == accountId) {
				updatedAccount = accountData;
				account.setAccountId(accountId);
				account.setAccountType(accountData.getAccountType());
				account.setBalance(accountData.getBalance());
				break;
			}
		}
		return updatedAccount;
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account deletedAccount = null;
		Iterator<Account> iter = accountList.iterator();
		while(iter.hasNext()) {
			Account account = iter.next();
			if(accountId == account.getAccountId()) {
				deletedAccount = account;
				iter.remove();
			}
		}
		return deletedAccount;
	}

}

package com.abcbank.tracker.entities;

import java.util.Set;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {
	
	@NonNull
	private int accountId;
	@NonNull
	private String accountType;
	@NonNull
	private double balance;
	Set<Customer> customerSet;
}

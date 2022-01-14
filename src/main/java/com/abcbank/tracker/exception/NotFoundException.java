package com.abcbank.tracker.exception;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String errorMessage) {
		super(errorMessage);
	}
}

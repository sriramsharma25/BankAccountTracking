package com.abcbank.tracker.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abcbank.tracker.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundException(NotFoundException nfex) {
		CustomErrorResponse ceresponse = new CustomErrorResponse("NOT_FOUND_ERROR", nfex.getMessage());
		ceresponse.setTimeStamp(LocalDateTime.now());
		ceresponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<CustomErrorResponse> (ceresponse, HttpStatus.NOT_FOUND);
	}
}

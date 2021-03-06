package com.yourstories.controllers.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yourstories.exceptions.NoAccountsFoundException;
import com.yourstories.exceptions.NoTagsFoundException;

@RestControllerAdvice
public class AccountControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value={NoAccountsFoundException.class})
	private ResponseEntity<?> handleAccountNotFound(Exception ex, WebRequest req){
		if(ex instanceof NoAccountsFoundException){
			NoAccountsFoundException noex = (NoAccountsFoundException) ex;
			return handleExceptionInternal(noex, noex.getMessage(), 
			          new HttpHeaders(), HttpStatus.CONFLICT, req);
		}
		 return handleExceptionInternal(ex, ex.getMessage(), 
		          new HttpHeaders(), HttpStatus.CONFLICT, req);
	}
	
}

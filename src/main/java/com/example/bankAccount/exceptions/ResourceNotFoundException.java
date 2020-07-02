package com.example.bankAccount.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}

package com.dagim.rs.exception;

public class UserNotFoundException extends Exception {
	/*
	 * Throws exception from the login service class 
	 * whenever the customerid/password is not matching
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message){
		super(message);
	}
}

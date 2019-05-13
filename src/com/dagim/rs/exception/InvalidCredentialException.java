package com.dagim.rs.exception;

public class InvalidCredentialException extends Exception {
	/*
	 * Thrown when the login credentials have invalid format
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidCredentialException(String message){
		super(message);
	}
}

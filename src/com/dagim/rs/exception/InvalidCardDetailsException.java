package com.dagim.rs.exception;

public class InvalidCardDetailsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidCardDetailsException(String message){
		super(message);
	}

}

package com.dagim.rs.exception;

public class CreditCardNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditCardNotFoundException(String message){
		super(message);
	}

}

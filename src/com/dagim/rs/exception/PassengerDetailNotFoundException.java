package com.dagim.rs.exception;

public class PassengerDetailNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PassengerDetailNotFoundException(String message){
		super(message);
	}
}

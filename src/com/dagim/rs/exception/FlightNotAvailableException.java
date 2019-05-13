package com.dagim.rs.exception;

public class FlightNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FlightNotAvailableException(String message){
		super(message);
	}
}

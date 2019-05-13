package com.dagim.rs.exception;

public class SeatsNotAvailableException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public SeatsNotAvailableException(String message){
		super(message);
	}
}	

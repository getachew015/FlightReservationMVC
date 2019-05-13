package com.dagim.rs.exception;

public class InvalidJourneyDateException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidJourneyDateException(String message){
		super(message);
	}
}

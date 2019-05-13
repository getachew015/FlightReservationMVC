package com.dagim.rs.exception;

public class ARSServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public ARSServiceException(String code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ARSServiceException(String message) {
		super(message);		
	}

}

package com.dagim.rs.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ClientErrorInformation errorHandler(Exception ex){
		
		ClientErrorInformation errorInfo = new ClientErrorInformation();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage("Server encountered unexpected error!");
		return errorInfo;
		
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	public ClientErrorInformation handlePublicErrors(Exception ex){
		ClientErrorInformation errorInfo = new ClientErrorInformation();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage("Bad request has been submited!");
		return null;
		
	}
	
	
}

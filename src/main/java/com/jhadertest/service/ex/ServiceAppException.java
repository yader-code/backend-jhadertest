package com.jhadertest.service.ex;

public class ServiceAppException extends Exception{

	private static final long serialVersionUID = 1L;

	public ServiceAppException(String message){
		super(message);
	}
	
	public ServiceAppException(String message, Throwable cause){
		super(message, cause);
	}
}

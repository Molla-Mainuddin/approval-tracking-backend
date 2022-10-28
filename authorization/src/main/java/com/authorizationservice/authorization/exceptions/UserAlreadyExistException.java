package com.authorizationservice.authorization.exceptions;

public class UserAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException(String exceptionMessage) {
        super(exceptionMessage);
	}

}

package com.authorizationservice.authorization.exceptions;

public class MemberIdNotAllowedFromUser extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MemberIdNotAllowedFromUser(String message) {
		super(message);
	}
}

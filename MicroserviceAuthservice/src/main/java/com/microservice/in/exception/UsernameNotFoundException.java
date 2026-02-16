package com.microservice.in.exception;

public class UsernameNotFoundException extends RuntimeException{
	
	public UsernameNotFoundException() {
		super("User not found");
	}
	
	public UsernameNotFoundException(String message) {
		super(message);
	}
	

}

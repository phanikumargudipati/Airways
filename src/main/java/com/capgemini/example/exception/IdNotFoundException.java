package com.capgemini.example.exception;

public class IdNotFoundException extends Exception{
	String message;
	public IdNotFoundException(String message) {
		super();
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	

}

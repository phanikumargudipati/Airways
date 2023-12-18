package com.capgemini.example.exception;

public class AlreadyExistsException extends Exception{
	String message;
	public AlreadyExistsException(String message) {
		super();
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	

}

package com.capgemini.example.exception;

public class InvalidNameException extends Exception {
	String message;
	public InvalidNameException(String message) {
		super();
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	

}

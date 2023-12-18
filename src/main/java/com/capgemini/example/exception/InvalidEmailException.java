package com.capgemini.example.exception;

public class InvalidEmailException extends Exception {
	String message;
	public InvalidEmailException(String message) {
		super();
		this.message=message;
	}
	public String getMessage() {
		return this.message;
	}
	

}

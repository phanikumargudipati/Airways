package com.capgemini.example.exception;

public class FlightNotFoundException extends Exception {
	String message;
	public FlightNotFoundException(String message) {
		super();
		this.message=message;
		
	}
	public String getMessage() {
		return this.message;
	}
	

}

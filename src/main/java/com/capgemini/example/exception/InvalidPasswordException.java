package com.capgemini.example.exception;

public class InvalidPasswordException extends Exception {
	String message;
public InvalidPasswordException(String message) {
	super();
	this.message=message;
}
public String getMessage() {
	return this.message;
}

}

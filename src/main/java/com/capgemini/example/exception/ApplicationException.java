package com.capgemini.example.exception;

public class ApplicationException extends RuntimeException{
	
	String msg;

	public ApplicationException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
    
}

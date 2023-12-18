package com.capgemini.example.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

	public class GlobalExceptionHandler {

	 ErrorResponse errorResponse = new ErrorResponse();
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleId(IdNotFoundException idNotFoundException)
		{
		
			errorResponse.setErrormessage(idNotFoundException.getMessage());
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(AlreadyExistsException.class)
		public ResponseEntity<ErrorResponse> handleAlreadyExists(AlreadyExistsException alreadyExistsException)
		{
	       
	        errorResponse.setErrormessage(alreadyExistsException.getMessage());
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
	        errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(InvalidNameException.class)
		public ResponseEntity<ErrorResponse> handleName(InvalidNameException invalidNameException)
		{
	    
	        errorResponse.setErrormessage(invalidNameException.getMessage());
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
	        errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(InvalidPasswordException.class)
		public ResponseEntity<ErrorResponse> handlePassword(InvalidPasswordException invalidPasswordException)
		{
	       
	        errorResponse.setErrormessage(invalidPasswordException.getMessage());
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
	        errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(ApplicationException.class)
		public ResponseEntity<ErrorResponse> applicationException(ApplicationException applicationException)
		{
	       
	        errorResponse.setErrormessage(applicationException.getMsg());
	        errorResponse.setStatus(HttpStatus.FORBIDDEN.toString());
	        errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
		}
		
		@ExceptionHandler(FlightNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleFlight(FlightNotFoundException flightNotFoundException)
		{
	        errorResponse.setErrormessage(flightNotFoundException.getMessage());
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
	        errorResponse.setLocalDateTime(LocalDateTime.now());
	        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(InvalidEmailException.class)
		public ResponseEntity<ErrorResponse> handleEmail(InvalidEmailException invalidEmailException){
			
		        errorResponse.setErrormessage(invalidEmailException.getMessage());
		        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		        errorResponse.setLocalDateTime(LocalDateTime.now());
		        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		

}

package com.sprint.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
	@Value(value="${message1}")
	private String message1;
	
	@Value(value="${message2}")
	private String message2;
	
	@Value(value="${message3}")
	private String message3;
	
	@Value(value="${message4}")
	private String message4;
	
	
	@ExceptionHandler(value=BookingNotFoundException.class)
	public ResponseEntity BookingNotFoundException(BookingNotFoundException ex) {
		return new ResponseEntity(message1,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity CustomerNotFoundException(CustomerNotFoundException c) {
		return new ResponseEntity(message2,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=BookingAlreadyExistsException.class)
	public ResponseEntity NoBookingFoundException(BookingAlreadyExistsException b) {
		return new ResponseEntity(message3,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=BookingAlreadyExistsException.class)
	public ResponseEntity TransactionRecordNotFoundException(TransactionRecordNotFoundException b) {
		return new ResponseEntity(message4,HttpStatus.NOT_FOUND);
	}
	

	public GlobalHandlerException() {
		
		
		
	}

}

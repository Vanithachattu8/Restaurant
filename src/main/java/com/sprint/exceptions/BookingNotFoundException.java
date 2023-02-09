package com.sprint.exceptions;

public class BookingNotFoundException extends Exception{

	private String message;
	public BookingNotFoundException()
	{
		
	}

	public BookingNotFoundException(String s) {
		super(s);
		this.message=s;
	}

}

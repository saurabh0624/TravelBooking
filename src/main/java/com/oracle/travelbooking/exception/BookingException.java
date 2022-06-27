package com.oracle.travelbooking.exception;

public class BookingException extends RuntimeException {
	
	public BookingException(String message) {
		super(message);
	}
	
	public BookingException(Throwable cause) {
		super(cause);
	}

}

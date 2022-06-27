package com.oracle.travelbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oracle.travelbooking.model.ErrorResponse;



@ControllerAdvice
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BookingException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleBookingException(BookingException bookingException, WebRequest request) {
		
		ErrorResponse response = new ErrorResponse(bookingException.getMessage(), HttpStatus.NOT_FOUND);
		return response;
	}
	
	/*@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptableException(DepartmentException departmentException) {
		
		ErrorResponse response = new ErrorResponse(departmentException.getMessage(), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}*/
}

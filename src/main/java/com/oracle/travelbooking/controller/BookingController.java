package com.oracle.travelbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.travelbooking.entity.Booking;
import com.oracle.travelbooking.exception.BookingException;
import com.oracle.travelbooking.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookings")
	public Booking saveBooking(@Valid @RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}
	
	@GetMapping("/bookings/{id}")
	public Booking getBookingById(@PathVariable("id") Long bookingId) throws BookingException {
		return bookingService.getBookingsById(bookingId);
	}

	@GetMapping("/bookings")
	public List<Booking> getBooking() {
		return bookingService.getBookings();
	}
	
	@DeleteMapping("/bookings/{id}")
	public String deleteBookingById(@PathVariable("id") Long bookingId) {
		bookingService.deleteBookingsById(bookingId);
		return "Records Deleted";
	}
	
	@PutMapping("/bookings/{id}")
	public Booking updateBookingById(@PathVariable("id") Long bookingId, @RequestBody Booking booking) {
		return bookingService.updateBookingsById(bookingId, booking);
	}
}

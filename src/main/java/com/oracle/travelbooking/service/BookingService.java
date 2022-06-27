package com.oracle.travelbooking.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.travelbooking.entity.Booking;
import com.oracle.travelbooking.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking saveBooking(Booking booking) {
		
		return bookingRepository.save(booking);
	}

	public List<Booking> getBookings() {
		
		return bookingRepository.findAll();
	}

	public Booking getBookingsById(Long bookingId) {

		return bookingRepository.findById(bookingId).get();		//exceptionHandling for: if id not present
	}
	
	public void deleteBookingsById(Long bookingId) {

		bookingRepository.deleteById(bookingId);
	}

	public Booking updateBookingsById(Long bookingId, Booking booking) {
		
		Booking bookingDB = getBookingsById(bookingId);
		
		if(Objects.nonNull(booking.getDestination()) && !("".equals(booking.getDestination())))
			bookingDB.setDestination(booking.getDestination());
		
		if(Objects.nonNull(booking.getHotelName()) && !("".equals(booking.getHotelName())))
			bookingDB.setHotelName(booking.getHotelName());
		
		if(Objects.nonNull(booking.getActivities()) && !("".equals(booking.getActivities())))
			bookingDB.setActivities(booking.getActivities());
		
		if(Objects.nonNull(booking.getVehicle()) && !("".equals(booking.getVehicle())))
			bookingDB.setVehicle(booking.getVehicle());
		
		if(Objects.nonNull(booking.getBookingAmount()))
			bookingDB.setBookingAmount(booking.getBookingAmount());
		
		if(Objects.nonNull(booking.getPaymentStatus()) && !("".equals(booking.getPaymentStatus())))
			bookingDB.setPaymentStatus(booking.getPaymentStatus());
		
		return bookingRepository.save(bookingDB);
	}

}

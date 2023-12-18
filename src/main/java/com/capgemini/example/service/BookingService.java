package com.capgemini.example.service;


import java.util.List;

import com.capgemini.example.entity.Booking;
import com.capgemini.example.exception.IdNotFoundException;


public interface BookingService {

	Booking addBooking(Booking booking);
	List<Booking> getAllBookings() throws IdNotFoundException;
	Booking getBookingsById(int bookingId) throws IdNotFoundException;
	String deletePassengerDetailsByBookingId(int bookingId);
}

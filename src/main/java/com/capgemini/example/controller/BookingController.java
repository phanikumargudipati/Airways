package com.capgemini.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.example.entity.Booking;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.service.BookingService;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/flight-booking")
	public ResponseEntity<Booking> addbooking(@RequestBody Booking booking){
		System.out.println(booking);
		return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBookings() throws IdNotFoundException{
		return new ResponseEntity<List<Booking>> (bookingService.getAllBookings(), HttpStatus.OK);
	}
	
	@GetMapping("/getBookingsById/{bookingId}")
	public ResponseEntity<Booking> getBookingsByBookingId(@PathVariable("bookingId") int bookingId) throws IdNotFoundException{
		return new ResponseEntity<Booking> (bookingService.getBookingsById(bookingId), HttpStatus.OK);
	}

	@GetMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable("bookingId") int bookingId){
		return new ResponseEntity<String>(bookingService.deletePassengerDetailsByBookingId(bookingId),HttpStatus.OK);
	}
}

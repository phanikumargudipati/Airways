package com.capgemini.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.example.entity.Booking;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.repository.BookingRepository;
import com.capgemini.example.repository.FlightRepository;
import com.capgemini.example.repository.PassengerRepository;
import com.capgemini.example.repository.UserRepository;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	
	public Booking getBookingsById(int bookingId) throws IdNotFoundException{
		 Booking booking=bookingRepository.findBookingsByBookingId(bookingId);
		 if(booking== null) {
			 throw new IdNotFoundException("Booking id is not present in the db");
		 }
		 return booking;
	}

	public Booking addBooking(Booking booking) {
		

	    User user =	userRepository.findById(booking.getUser().getUserId()).get();
	    
	    double totalCost = 0;
	    List<Passenger> passengers =  booking.getPassengers();
	    booking.setUser(user);
	    Flight flight = flightRepository.findById(booking.getFlight().getFlightId()).get();
	    totalCost =  (passengers.size() * flight.getFare());
	    booking.setTotalCost(totalCost);
	    booking.setFlight(flight);
	   
	    int remainingSeat = flight.getRemainingSeats()-booking.getPassengers().size();
	    flight.setRemainingSeats(remainingSeat);
	   

	    booking.setBookingStatus("Booked");
		bookingRepository.save(booking);
		return bookingRepository.save(booking);
	    
	}
	public String deletePassengerDetailsByBookingId(int bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		List<Passenger> passengerList = passengerRepository.fetchByBookingId(bookingId);
		int remainingSeats = passengerList.size();
		for(Passenger passenger: passengerList) {
			passengerRepository.deleteById(passenger.getPassengerId());
		}
		Flight flight=flightRepository.findById(booking.getFlight().getFlightId()).get();
		flight.setRemainingSeats(flight.getRemainingSeats()+remainingSeats);
		flightRepository.save(flight);
		booking.setBookingStatus("Cancelled");
		bookingRepository.save(booking);
		return "booking Cancelled Successfully";
	}

}

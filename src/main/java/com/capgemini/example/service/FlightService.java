package com.capgemini.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capgemini.example.dto.FlightDto;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Location;
import com.capgemini.example.exception.FlightNotFoundException;
import com.capgemini.example.exception.IdNotFoundException;

public interface FlightService {

	Flight addFlights(int userId, Flight flights);
	
	//Flight addFlight2(FlightDto flightDto);
	
	List<Flight> getFlights()throws FlightNotFoundException;
	
	Flight updateFlight(int flightId, Flight flight) throws IdNotFoundException, FlightNotFoundException;
	
	String deleteFlightById(int flightId)throws IdNotFoundException, FlightNotFoundException;
	
	List<Flight> getFlightsByLocationId(int locationId)throws IdNotFoundException, FlightNotFoundException;
	
	List<Flight> findFlightsByLocations(String departureLocation, String arrivalLocation)throws FlightNotFoundException;
	List<Flight> findFlightsByLocationsAndDate(String departureLocation,String arrivalLocation,LocalDateTime departureTime) throws FlightNotFoundException;
	List<Flight> findFlightsByLocationsAndFare(String departureLocation,String arrivalLocation,Double fare) throws FlightNotFoundException;
	 List<Flight> findByFareLessThanEqual(Double fare) throws FlightNotFoundException;
	 List<Flight> findFlightsByDate(@Param("departureTime") LocalDateTime departureTime) throws FlightNotFoundException;
	 Flight findFlightsByFlightId(@Param("flightId") int flightId)throws IdNotFoundException;
}

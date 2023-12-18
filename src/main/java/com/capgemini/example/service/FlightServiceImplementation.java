package com.capgemini.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Location;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.ApplicationException;
import com.capgemini.example.exception.FlightNotFoundException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.repository.FlightRepository;
import com.capgemini.example.repository.LocationRepository;
import com.capgemini.example.repository.UserRepository;

@Service
public class FlightServiceImplementation implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Flight addFlights( int userId, Flight flights) {
		
	User user =	userRepository.findById(userId).orElseThrow(()-> new ApplicationException("invalid id"));
		
	Flight flight = null;	
	  if(user.getRole().equalsIgnoreCase("admin"))
	  {
		  if(locationRepository.existsById(flights.getLocations().getLocationId()))
			{
				Location location = locationRepository.findById(flights.getLocations().getLocationId()).get();
				flights.setLocations(location);
			}
			 flight= flightRepository.save(flights);
	  }
	  else
	  {
		  throw new ApplicationException("only admin add");

	  }
	  
	  return flight;
	}

	public List<Flight> getFlights() {
		
		return flightRepository.findAll();
	}
	
	
	public Flight updateFlight(int flightId, Flight flight) throws IdNotFoundException, FlightNotFoundException {
		Flight updateFlight=null;
	
		if(flightRepository.existsById(flightId))
		{
			updateFlight=flightRepository.findById(flightId).get();
			
			flight.setFlightId(flightId);
			return flightRepository.save(flight);
		}
		else
		{
			throw new IdNotFoundException("No flight found to update with id");
		}
		}

	public String deleteFlightById(int flightId)throws IdNotFoundException, FlightNotFoundException {

		if(flightRepository.existsById(flightId))
		{
			flightRepository.deleteById(flightId);
			return "flight deleted successfully";
		}
		else {
			throw new IdNotFoundException("USER_ID_NOT_FOUND_INFO");
		}
	}

	public List<Flight> getFlightsByLocationId(int locationId)throws IdNotFoundException{
		List<Flight> flight= flightRepository.getAllFlightsByLocationId(locationId);
		if(flight.size()== 0) {
			 throw new IdNotFoundException("Flight is not available for given location");
		 }
		 return flight;
	}

	public List<Flight> findFlightsByLocations(String departureLocation, String arrivalLocation) throws FlightNotFoundException{
		List<Flight> flight= flightRepository.findFlightsByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation);
		if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given locations");
		 }
		 return flight;
	}
	public List<Flight> findFlightsByLocationsAndDate(String departureLocation,String arrivalLocation,LocalDateTime departureTime) throws FlightNotFoundException{
		List<Flight> flight= flightRepository.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime);
		if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given location");
		 }
		 return flight;
		}
	
	 public List<Flight> findByFareLessThanEqual(Double fare)throws FlightNotFoundException{
		 List<Flight> flight= flightRepository.findFlightsByFare(fare);
		 if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given fare");
		 }
		 return flight;
	 }
	 
	 public List<Flight> findFlightsByLocationsAndFare(String departureLocation,String arrivalLocation,Double fare) throws FlightNotFoundException{
			List<Flight> flight= flightRepository.findFlightsByLocationsAndFare(departureLocation, arrivalLocation, fare);
			if(flight.size()== 0) {
				 throw new FlightNotFoundException("Flight is not available for given fare for that location");
			 }
			 return flight;
			}
	 public List<Flight> findFlightsByDate(LocalDateTime departureTime) throws FlightNotFoundException{
		 List<Flight> flight = flightRepository.findFlightsByDate(departureTime);
		 if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available at given time");
		 }
		 return flight;
	 }
	 public Flight findFlightsByFlightId(int flightId)throws IdNotFoundException{
		 Flight flight=flightRepository.findFlightsByFlightId(flightId);
		 if(flight== null) {
			 throw new IdNotFoundException("Flight id is not present in the db");
		 }
		 return flight;
	 }
}

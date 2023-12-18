package com.capgemini.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.example.dto.FlightDto;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Location;
import com.capgemini.example.exception.FlightNotFoundException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.service.FlightService;

@RestController
@RequestMapping("api/v1")
public class FlightController {

	@Autowired
	FlightService flightservice;
	
	@PostMapping("/add-flights/admin/{userid}")
	public ResponseEntity<Flight> addFlights(@PathVariable("userid") int userid, @RequestBody Flight flights){
		return new ResponseEntity<Flight>(flightservice.addFlights(userid, flights), HttpStatus.OK);
	}
	
	@GetMapping("/getAllflights")
	public ResponseEntity <List<Flight>> getAllFlights()throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.getFlights(),HttpStatus.OK);
	}
	
	@PutMapping("/update-flight/admin/{flightId}")
	public ResponseEntity<Flight> updateFlightById(@PathVariable("flightId") int flightId,@RequestBody Flight flight) throws IdNotFoundException,FlightNotFoundException
	{
		return new ResponseEntity<Flight>(flightservice.updateFlight(flightId,flight), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-flight/{flightId}")
	public ResponseEntity<String> deleteFlightById(@PathVariable("flightId") Integer flightId,@RequestBody Flight flight) throws IdNotFoundException, FlightNotFoundException
	{
		return new ResponseEntity<String> (flightservice.deleteFlightById(flightId), HttpStatus.OK);
	}
	
	@GetMapping("/getFlightsByLocationId/{locationId}")
	public ResponseEntity<List<Flight>> getFlightsByLocationId(@PathVariable("locationId") int locationId)throws IdNotFoundException, FlightNotFoundException{
		return new ResponseEntity<List<Flight>> (flightservice.getFlightsByLocationId(locationId), HttpStatus.OK);
	}  
	
	@GetMapping("/getFlightsByLocations/{departureLocation}/{arrivalLocation}") 
	public ResponseEntity<List<Flight>> getFlightsByLocation(@PathVariable String departureLocation, @PathVariable String arrivalLocation) throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.findFlightsByLocations(departureLocation, arrivalLocation), HttpStatus.OK);
	}
	@GetMapping("/getFlightbyLocationsAndDate/{departureLocation}/{arrivalLocation}/{departureTime}") 
	public ResponseEntity<List<Flight>> findFlightsByLocationsAndDate(@PathVariable String departureLocation,@PathVariable String arrivalLocation,@PathVariable LocalDateTime departureTime) throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.findFlightsByLocationsAndDate(departureLocation,arrivalLocation,departureTime),HttpStatus.OK) ;
}
	
	@GetMapping("/getFlightbyLocationsAndFare/{departureLocation}/{arrivalLocation}/{fare}") 
	public ResponseEntity<List<Flight>> findFlightsByLocationsAndDate(@PathVariable String departureLocation,@PathVariable String arrivalLocation,@PathVariable Double fare) throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.findFlightsByLocationsAndFare(departureLocation,arrivalLocation,fare),HttpStatus.OK) ;
}
	@GetMapping("/getFlightByFare/{fare}")
	public ResponseEntity<List<Flight>> findByFareLessThanEquals(@PathVariable Double fare) throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.findByFareLessThanEqual(fare),HttpStatus.OK);
	}
	@GetMapping("/getFlightByDate/{departureTime}")
	public ResponseEntity<List<Flight>> findFlightsByDate(@PathVariable LocalDateTime departureTime) throws FlightNotFoundException{
		return new ResponseEntity<List<Flight>>(flightservice.findFlightsByDate(departureTime),HttpStatus.OK);
	}
	@GetMapping("/getFlightByFlightId/{flightId}")
	public ResponseEntity<Flight> findFlightsByFlightId(@PathVariable int flightId) throws IdNotFoundException{
		return new ResponseEntity<Flight>(flightservice.findFlightsByFlightId(flightId),HttpStatus.OK);
	}
}

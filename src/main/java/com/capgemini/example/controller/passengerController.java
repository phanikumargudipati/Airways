package com.capgemini.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.service.PassengerService;

@RestController
@RequestMapping("/api/v1")
public class passengerController {

	@Autowired
	PassengerService passengerService;
	
	@PostMapping("/add-passengers/user")
	public ResponseEntity<Passenger> addPassengers(@RequestBody Passenger passenger){
		return new ResponseEntity<Passenger>(passengerService.addPassenger(passenger), HttpStatus.OK);
	} 
	
	@GetMapping("/getAll-passengers")
	public ResponseEntity<List<Passenger>> getPassengers()
	{
		return new ResponseEntity<List<Passenger>>(passengerService.getPassenger(), HttpStatus.OK);
	}
	
}

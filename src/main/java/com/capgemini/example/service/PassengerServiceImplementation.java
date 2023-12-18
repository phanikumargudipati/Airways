package com.capgemini.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.example.entity.Location;
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.repository.PassengerRepository;

@Service
public class PassengerServiceImplementation implements PassengerService{

	@Autowired
	PassengerRepository passengerRepository; 
	
	public Passenger addPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	public List<Passenger> getPassenger(){
		return passengerRepository.findAll();
	}
	
	}


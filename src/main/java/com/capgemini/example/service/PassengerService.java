package com.capgemini.example.service;

import java.util.List;

import com.capgemini.example.entity.Passenger;

public interface PassengerService  {

	Passenger addPassenger(Passenger passenger);
	
	List<Passenger> getPassenger();
}

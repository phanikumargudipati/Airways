package com.capgemini.example.service;

import java.util.List;

import com.capgemini.example.entity.Location;
import com.capgemini.example.exception.IdNotFoundException;

public interface LocationService {

	Location addLocation(Location location);
	
	List<Location> getLocation();
	
	Location updateLocationById(int locationId, Location location) throws IdNotFoundException;
	
	String deleteLocationById(int locationId) throws IdNotFoundException;
}

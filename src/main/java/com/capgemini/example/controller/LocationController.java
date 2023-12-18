package com.capgemini.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.example.entity.Location;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.service.LocationService;

@RestController
@RequestMapping("api/v1")
public class LocationController {

	@Autowired
	LocationService service;
	
	@PostMapping("/addLocation/admin")
	public ResponseEntity<Location> addFlightLocations(@RequestBody Location location){
		return new ResponseEntity<Location>(service.addLocation(location), HttpStatus.OK);
	}
	
	@GetMapping("/getLocations")
	public ResponseEntity<List<Location>> getFlightLocations(){
		return new ResponseEntity<List<Location>>(service.getLocation(), HttpStatus.OK);
	}
	
	@PutMapping("/update-location/admin/{locationid}")
	public ResponseEntity<Location> updateLocationById(@PathVariable("locationid") Integer locationId,@RequestBody Location location) throws IdNotFoundException
	{
		return new ResponseEntity<Location>(service.updateLocationById(locationId,location), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/delete-location/{locationId}")
	public ResponseEntity<String> deleteLocationById(@PathVariable("locationId") Integer locationId,@RequestBody Location location) throws IdNotFoundException
	{
		return new ResponseEntity<String> (service.deleteLocationById(locationId), HttpStatus.OK);
	}
	
		
}

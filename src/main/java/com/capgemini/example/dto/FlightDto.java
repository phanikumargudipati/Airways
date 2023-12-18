package com.capgemini.example.dto;

import java.time.LocalDateTime;

public class FlightDto {
	private int flightId;
	private String departureLocation;
	private String arrivalLocation;
	private String code;
	private String model;
	private int totalSeats;
	private double fare;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int remainingSeats;
	
	private int locationId;
	
	
	
	

	public FlightDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public FlightDto(int flightId, String departureLocation, String arrivalLocation, String code, String model,
			int totalSeats, double fare, LocalDateTime departureTime, LocalDateTime arrivalTime, int remainingSeats,
			int locationId) {
		super();
		this.flightId = flightId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.code = code;
		this.model = model;
		this.totalSeats = totalSeats;
		this.fare = fare;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.remainingSeats = remainingSeats;
		this.locationId = locationId;
	}



	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
}

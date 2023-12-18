package com.capgemini.example.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	private String departureLocation;
	private String arrivalLocation;
	private String code;
	private String model;
	private int totalSeats;
	private double fare;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private int remainingSeats;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="location_id",referencedColumnName="location_id")
	@JsonBackReference(value="location_id")
	private Location locations;
	
	
	public Flight() {
		super();
	}


	
	
	public Flight(int flightId, String departureLocation, String arrivalLocation, String code, String model,
			int totalSeats, double fare, LocalDateTime departureTime, LocalDateTime arrivalTime, int remainingSeats,
			Location locations) {
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
		this.locations = locations;
	}


	


	public Flight(String departureLocation, String arrivalLocation, String code, String model, int totalSeats,
			double fare,
			LocalDateTime departureTime, LocalDateTime arrivalTime, int remainingSeats,
			 Location locations) {
		super();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.code = code;
		this.model = model;
		this.totalSeats=totalSeats;
		this.fare=fare;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.remainingSeats=remainingSeats;
		this.locations = locations;
	}
	


	public Flight(int flightId, String departureLocation, String arrivalLocation, String code, String model,
			int totalSeats, double fare, LocalDateTime departureTime, LocalDateTime arrivalTime, int remainingSeats) {
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
		this.remainingSeats = this.totalSeats;
	}

	public double getFare() {
		return fare;
	}


	public void setFare(double fare) {
		this.fare = fare;
	}
	

	public int getRemainingSeats() {
		return remainingSeats;
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


	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public Location getLocations() {
		return locations;
	}


	public void setLocations(Location locations) {
		this.locations = locations;
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", code=" + code + ", model=" + model + ", totalSeats=" + totalSeats
				+ ", fare=" +fare + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", remainingSeats="
				+ remainingSeats + ", locations=" + locations + "]";
	}

	
	
	

}

package com.capgemini.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




@Entity
@Table(name="Locations")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_id")
	private int locationId;
	private String name;
	private String code;
	private String country;
	private String airportName;
	@OneToMany(mappedBy="locations",cascade=CascadeType.ALL)
	@JsonManagedReference(value="location_id")
	private List<Flight> flight;
	
	
	public Location() {
		super();
	}


	public Location(String name, String code, String country, String airportName, List<Flight> flight) {
		super();
		this.name = name;
		this.code = code;
		this.country = country;
		this.airportName = airportName;
		this.flight = flight;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getAirportName() {
		return airportName;
	}


	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}


	public List<Flight> getFlight() {
		return flight;
	}


	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}


	public Location(int locationId, String name, String code, String country, String airportName, List<Flight> flight) {
		this.locationId = locationId;
		this.name = name;
		this.code = code;
		this.country = country;
		this.airportName = airportName;
		this.flight = flight;
	}


	public Location(int locationId, String name, String code, String country, String airportName) {
		super();
		this.locationId = locationId;
		this.name = name;
		this.code = code;
		this.country = country;
		this.airportName = airportName;
	}


	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", name=" + name + ", code=" + code + ", country=" + country
				+ ", airportName=" + airportName + ", flight=" + flight + "]";
	}
	
	

}

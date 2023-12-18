package com.capgemini.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String type;
	private String addressLine;
	private long zipCode;
	private String city;
	private String state;
	private String country;
	
	
	public Address() {
		
	}


	public Address(String type, String addressLine, long zipCode, String city, String state, String country) {
		super();
		this.type = type;
		this.addressLine = addressLine;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}


	public long getZipCode() {
		return zipCode;
	}


	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", type=" + type + ", addressLine=" + addressLine + ", zipCode="
				+ zipCode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

	
}

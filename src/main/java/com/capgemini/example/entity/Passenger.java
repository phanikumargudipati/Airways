package com.capgemini.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passengerId;
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	private String passportNo;
	private String mealPref;
	@ManyToOne
	@JoinColumn(name="bookingId",referencedColumnName="booking_id")
	@JsonBackReference(value="booking_id")
	Booking booking;
	public Passenger() {
		super();
	}
	public Passenger(String firstName, String lastName, int age, char gender, String passportNo, String mealPref,
			Booking booking) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.passportNo = passportNo;
		this.mealPref = mealPref;
		this.booking = booking;
	}
	
	public Passenger(int passengerId, String firstName, String lastName, int age, char gender, String passportNo,
			String mealPref) {
		super();
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.passportNo = passportNo;
		this.mealPref = mealPref;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getMealPref() {
		return mealPref;
	}
	public void setMealPref(String mealPref) {
		this.mealPref = mealPref;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", passportNo=" + passportNo + ", mealPref=" + mealPref + ", booking="
				+ booking.getBookingId() + "]";
	}

	
}

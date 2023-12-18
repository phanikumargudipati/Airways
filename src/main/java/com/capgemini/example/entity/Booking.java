package com.capgemini.example.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	private LocalDateTime bookingDate;
	private LocalDateTime travelDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	private double totalCost;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonBackReference(value = "user_id")
	private User user;

	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "booking_id")
	private List<Passenger> passengers;

	@OneToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;

	@Column(name = "booking_status")
	private String bookingStatus = "Completed";

	public Booking() {
		super();
	}

	public Booking( LocalDateTime bookingDate, LocalDateTime travelDate, double totalCost,
			double amount, User user, List<Passenger> passengers, Flight flight, String bookingStatus) {
		super();

		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.totalCost = totalCost;
		this.amount = amount;
		this.user = user;
		this.passengers = passengers;
		this.flight = flight;
		this.bookingStatus = bookingStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
		this.amount = this.flight.getFare();
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate
				+ ", travelDate=" + travelDate + ", totalCost=" + totalCost + ", amount=" + amount + ", user="
				+ user.getUserId() + ", passengers=" + passengers + ", flight=" + flight.getFlightId()
				+ ", bookingStatus=" + bookingStatus + "]";
	}

}

package com.capgemini.example.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String userName;

	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	private long mobileNo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_Id")
	private Address address;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)

	private List<Booking> booking;
	
    private String role="user";

	
	public User() {
		super();
	}


	public User(String userName, String password, String firstName, String lastName, String email, long mobileNo,
			Address address, List<Booking> booking) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.booking = booking;
	}

	

	public User(String userName, String password, String firstName, String lastName, String email, long mobileNo,
			Address address, List<Booking> booking, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.booking = booking;
		this.role = role;
	}

	
	

	public User(int userId, String userName, String password, String firstName, String lastName, String email,
			long mobileNo, Address address, List<Booking> booking, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
		this.booking = booking;
		this.role = role;
	}


	public User(int userId, String role) {
		this.userId=userId;
		this.role=role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", address="
				+ address + ", booking=" + booking + ", role=" + role + "]";
	}


	
	
	

}

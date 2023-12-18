package com.capgemini.example.dto;

public class PassengerDto {
	
	private int passengerId;
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	private String passportNo;
	private String mealPref;
	
	
	
	
	public PassengerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PassengerDto(int passengerId, String firstName, String lastName, int age, char gender, String passportNo,
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
	public void setId(int passengerId) {
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
	
	

}

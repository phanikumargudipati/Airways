package com.capgemini.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDto {

	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNo;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	private String updateUserUrl;
	private String bookFlightsUrl;
	private String cancelBookingUrl;
	private String resetPasswordUrl;
	private String getAllFlightsUrl;
	private String getAllLocationsUrl;
	private String searchFlightsByLocationIdUrl;
	private String searchFlightsByLocationsUrl;
	private String searchFlightsByLocationsAndDateUrl;
	private String searchFlightsByFlightFareUrl;
	private String searchFlightsByDateUrl;
	private String searchFlightsByLocationsAndFareUrl;
	private String searchFlightByFlightIdUrl;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int userId, String userName, String firstName, String lastName, String email, long mobileNo,
			String password, String confirmPassword, String updateUserUrl, String bookFlightsUrl,
			String cancelBookingUrl, String resetPasswordUrl, String getAllFlightsUrl, String getAllLocationsUrl,
			String searchFlightsByLocationIdUrl, String searchFlightsByLocationsUrl,
			String searchFlightsByLocationsAndDateUrl, String searchFlightsByFlightFareUrl,
			String searchFlightsByDateUrl, String searchFlightsByLocationsAndFareUrl,
			String searchFlightByFlightIdUrl) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.updateUserUrl = updateUserUrl;
		this.bookFlightsUrl = bookFlightsUrl;
		this.cancelBookingUrl = cancelBookingUrl;
		this.resetPasswordUrl = resetPasswordUrl;
		this.getAllFlightsUrl = getAllFlightsUrl;
		this.getAllLocationsUrl = getAllLocationsUrl;
		this.searchFlightsByLocationIdUrl = searchFlightsByLocationIdUrl;
		this.searchFlightsByLocationsUrl = searchFlightsByLocationsUrl;
		this.searchFlightsByLocationsAndDateUrl = searchFlightsByLocationsAndDateUrl;
		this.searchFlightsByFlightFareUrl = searchFlightsByFlightFareUrl;
		this.searchFlightsByDateUrl = searchFlightsByDateUrl;
		this.searchFlightsByLocationsAndFareUrl = searchFlightsByLocationsUrl;
		this.searchFlightByFlightIdUrl = searchFlightByFlightIdUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		this.updateUserUrl = "http://localhost:9099/api/v1/update/" + this.userId;
		this.bookFlightsUrl = "http://localhost:9099/api/v1/flight-booking";
		this.cancelBookingUrl = "http://localhost:9099/api/v1/cancelBooking/{bookingId}";
		this.resetPasswordUrl = "http://localhost:9099/api/v1/resetPassword/" + this.userId;
		this.getAllFlightsUrl = "http://localhost:9099/api/v1/getAllflights";
		this.getAllLocationsUrl = "http://localhost:9099/api/v1/getLocations";
		this.searchFlightsByLocationIdUrl = "localhost:9099/api/v1/getFlightsByLocationId/{locationId}";
		this.searchFlightsByLocationsUrl = "http://localhost:9099/api/v1/getFlightsByLocations/{departureLocation}/{arrivalLocation}";
		this.searchFlightsByLocationsAndDateUrl = "http://localhost:9099/api/v1/getFlightbyLocationsAndDate/{departureLocation}/{arrivalLocation}/{departureTime}";
		this.searchFlightsByDateUrl = "http://localhost:9099/api/v1/getFlightByDate/{departureTime}";
		this.searchFlightsByFlightFareUrl = "http://localhost:9099/api/v1/getFlightByFare/{fare}";
		this.searchFlightsByLocationsAndFareUrl = "http://localhost:9099/api/v1/getFlightByLocationsAndFare/{departureLocation}/{arrivalLocation}/{fare}";
		this.searchFlightByFlightIdUrl = "http://localhost:9099/api/v1/getFlightByFlightId/{flightId}";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getBookFlightsUrl() {
		return bookFlightsUrl;
	}

	public void setBookFlightsUrl(String bookFlightsUrl) {
		this.bookFlightsUrl = bookFlightsUrl;
	}

	public String getUpdateUserUrl() {
		return updateUserUrl;
	}

	public void setUpdateUserUrl(String updateUserUrl) {
		this.updateUserUrl = updateUserUrl;
	}

	public String getCancelBookingUrl() {
		return cancelBookingUrl;
	}

	public void setCancelBookingUrl(String cancelBookingUrl) {
		this.cancelBookingUrl = cancelBookingUrl;
	}

	public String getResetPasswordUrl() {
		return resetPasswordUrl;
	}

	public void setResetPasswordUrl(String resetPasswordUrl) {
		this.resetPasswordUrl = resetPasswordUrl;
	}

	public String getGetAllFlightsUrl() {
		return getAllFlightsUrl;
	}

	public void setGetAllFlightsUrl(String getAllFlightsUrl) {
		this.getAllFlightsUrl = getAllFlightsUrl;
	}

	public String getGetAllLocationsUrl() {
		return getAllLocationsUrl;
	}

	public void setGetAllLocationsUrl(String getAllLocationsUrl) {
		this.getAllLocationsUrl = getAllLocationsUrl;
	}

	public String getSearchFlightsByLocationsUrl() {
		return searchFlightsByLocationsUrl;
	}

	public void setSearchFlightsByLocationsUrl(String searchFlightsByLocationsUrl) {
		this.searchFlightsByLocationsUrl = searchFlightsByLocationsUrl;
	}

	public String getSearchFlightsByLocationsAndDateUrl() {
		return searchFlightsByLocationsAndDateUrl;
	}

	public void setSearchFlightsByLocationsAndDateUrl(String searchFlightsByLocationsAndDateUrl) {
		this.searchFlightsByLocationsAndDateUrl = searchFlightsByLocationsAndDateUrl;
	}

	public String getSearchFlightsByFlightFareUrl() {
		return searchFlightsByFlightFareUrl;
	}

	public void setSearchFlightsByFlightFareUrl(String searchFlightsByFlightFareUrl) {
		this.searchFlightsByFlightFareUrl = searchFlightsByFlightFareUrl;
	}

	public String getSearchFlightsByDateUrl() {
		return searchFlightsByDateUrl;
	}

	public void setSearchFlightsByDateUrl(String searchFlightsByDateUrl) {
		this.searchFlightsByDateUrl = searchFlightsByDateUrl;
	}

	public String getSearchFlightsByLocationsAndFareUrl() {
		return searchFlightsByLocationsAndFareUrl;
	}

	public void setSearchFlightsByLocationsAndFareUrl(String searchFlightsByLocationsAndFareUrl) {
		this.searchFlightsByLocationsAndFareUrl = searchFlightsByLocationsAndFareUrl;
	}

	public String getSearchFlightsByLocationIdUrl() {
		return searchFlightsByLocationIdUrl;
	}

	public void setSearchFlightsByLocationIdUrl(String searchFlightsByLocationIdUrl) {
		this.searchFlightsByLocationIdUrl = searchFlightsByLocationIdUrl;
	}

	public String getSearchFlightByFlightIdUrl() {
		return searchFlightByFlightIdUrl;
	}

	public void setSearchFlightByFlightIdUrl(String searchFlightByFlightIdUrl) {
		this.searchFlightByFlightIdUrl = searchFlightByFlightIdUrl;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", updateUserUrl=" + updateUserUrl + ", bookFlightsUrl="
				+ bookFlightsUrl + ", cancelBookingUrl=" + cancelBookingUrl + ", resetPasswordUrl=" + resetPasswordUrl
				+ ", getAllFlightsUrl=" + getAllFlightsUrl + ", getAllLocationsUrl=" + getAllLocationsUrl
				+ ", searchFlightsByLocationIdUrl=" + searchFlightsByLocationIdUrl + ", searchFlightsByLocationsUrl="
				+ searchFlightsByLocationsUrl + ", searchFlightsByLocationsAndDateUrl="
				+ searchFlightsByLocationsAndDateUrl + ", searchFlightsByFlightFareUrl=" + searchFlightsByFlightFareUrl
				+ ", searchFlightsByDateUrl=" + searchFlightsByDateUrl + ", searchFlightsByLocationsAndFareUrl="
				+ searchFlightsByLocationsAndFareUrl + ", searchFlightByFlightIdUrl=" + searchFlightByFlightIdUrl + "]";
	}

}

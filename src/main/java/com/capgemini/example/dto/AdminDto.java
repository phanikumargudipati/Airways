package com.capgemini.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class AdminDto {

	private String getFlightsUrl;
	private String addFlightsUrl;
	private String updateFlightsUrl;
	private String getLocationsUrl;
	private String addLocationsUrl;
    private String updateLocationsUrl;
	private String getBookingsUrl;
	private String getAllUsersUrl;
	@JsonProperty(access=Access.WRITE_ONLY)
	private int userId;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String role;
	public AdminDto() {
		super();
	}
	public AdminDto(String getFlightsUrl, String addFlightsUrl, String updateFlightsUrl, String getLocationsUrl,
			String addLocationsUrl,String updateLocationsUrl, String getBookingsUrl, int userId, String role, String getAllUsersUrl) {
		super();
		this.getFlightsUrl = getFlightsUrl;
		this.addFlightsUrl = addFlightsUrl;
		this.updateFlightsUrl = updateFlightsUrl;
		this.getLocationsUrl = getLocationsUrl;
		this.addLocationsUrl = addLocationsUrl;
		this.updateLocationsUrl = updateLocationsUrl;
		this.getBookingsUrl = getBookingsUrl;
		this.getAllUsersUrl = getAllUsersUrl;
		this.userId = userId;
		this.role = role;
	}
	public String getGetFlightsUrl() {
		return getFlightsUrl;
	}
	public void setGetFlightsUrl(String getFlightsUrl) {
		this.getFlightsUrl = getFlightsUrl;
	}
	public String getAddFlightsUrl() {
		return addFlightsUrl;
	}
	public void setAddFlightsUrl(String addFlightsUrl) {
		this.addFlightsUrl = addFlightsUrl;
	}
	public String getUpdateFlightsUrl() {
		return updateFlightsUrl;
	}
	public void setUpdateFlightsUrl(String updateFlightsUrl) {
		this.updateFlightsUrl = updateFlightsUrl;
	}
	public String getGetLocationsUrl() {
		return getLocationsUrl;
	}
	public void setGetLocationsUrl(String getLocationsUrl) {
		this.getLocationsUrl = getLocationsUrl;
	}
	public String getAddLocationsUrl() {
		return addLocationsUrl;
	}
	public void setAddLocationsUrl(String addLocationsUrl) {
		this.addLocationsUrl = addLocationsUrl;
	}
	public String getUpdateLocationsUrl() {
		return updateLocationsUrl;
	}
	public void setUpdateLocationsUrl(String updateLocationsUrl) {
		this.updateLocationsUrl = updateLocationsUrl;
	}
	public String getGetBookingsUrl() {
		return getBookingsUrl;
	}
	public void setGetBookingsUrl(String getBookingsUrl) {
		this.getBookingsUrl = getBookingsUrl;
	}
	public int getUserId() {
		return userId;
	}
	
	public String getGetAllUsersUrl() {
		return getAllUsersUrl;
	}
	public void setGetAllUsersUrl(String getAllUsersUrl) {
		this.getAllUsersUrl = getAllUsersUrl;
	}
	public void setUserId(int userId) {
		this.userId = userId;
		this.addFlightsUrl="http://localhost:9099/api/v1/add-flights/admin";
		this.updateFlightsUrl="http://localhost:9099/api/v1/update-flight/admin/{flightId}";
		this.getFlightsUrl="http://localhost:9099/api/v1/getAllflights";
		this.addLocationsUrl="http://localhost:9099/api/v1/addLocation/admin";
		this.updateLocationsUrl="http://localhost:9099/api/v1/update-location/admin/{locationId}";
		this.getLocationsUrl="http://localhost:9099/api/v1/getLocations";
		this.getBookingsUrl="http://localhost:9099/api/v1/getAllBookings";
		this.getAllUsersUrl="http://localhost:9099/api/v1/admin/get-users";
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = "role";
	}
	
	
	
}

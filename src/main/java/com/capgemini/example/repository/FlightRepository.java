package com.capgemini.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.example.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	@Query(value="select * from flight where location_id=:locationId",nativeQuery=true)
	public List<Flight> getAllFlightsByLocationId(@Param("locationId")int locationId);
	
	
	@Query("SELECT f from Flight f WHERE f.departureLocation=?1 and f.arrivalLocation=?2")
	List<Flight> findFlightsByDepartureLocationAndArrivalLocation(@Param("departureLocation")String departureLocation,@Param("arrivalLocation")String arrivalLocation);

 
	@Query("SELECT f FROM Flight f WHERE f.departureLocation=?1 and f.arrivalLocation=?2 and f.departureTime =?3")
	    List<Flight> findFlightsByLocationsAndDate(@Param("departureLocation") String departureLocation,@Param("arrivalLocation") String arrivalLocation,@Param("departureTime") LocalDateTime departureTime);
	 
	
	@Query("SELECT f FROM Flight f WHERE f.departureLocation=?1 and f.arrivalLocation=?2 and f.fare =?3")
    List<Flight> findFlightsByLocationsAndFare(@Param("departureLocation") String departureLocation,@Param("arrivalLocation") String arrivalLocation,@Param("fare") Double fare);
	
	
	@Query("SELECT f FROM Flight f WHERE f.fare <=?1")
	    List<Flight> findFlightsByFare(@Param("fare") Double fare);
	 
	@Query("SELECT f FROM Flight f WHERE f.departureTime >=?1")
	    List<Flight> findFlightsByDate(@Param("departureTime") LocalDateTime departureTime);

	 @Query("SELECT f FROM Flight f WHERE f.flightId=?1")
	    Flight findFlightsByFlightId(@Param("flightId") int flightId);
}

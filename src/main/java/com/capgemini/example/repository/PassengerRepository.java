package com.capgemini.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.example.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	@Query(value="select * from passenger where booking_id=:bookingId",nativeQuery=true)
	List<Passenger> fetchByBookingId(@Param("bookingId") int bookingId);
	
}

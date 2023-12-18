package com.capgemini.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.example.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	Booking findBookingsByBookingId(int bookingId);
}

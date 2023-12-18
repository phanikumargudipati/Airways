package com.capgemini.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.example.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}

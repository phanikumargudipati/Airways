package com.capgemini.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.example.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}

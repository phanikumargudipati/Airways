package com.capgemini.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.example.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUserId(int id);
	User findByEmail(String s);
	User findByPassword(String s);
}

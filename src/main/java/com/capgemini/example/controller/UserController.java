package com.capgemini.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.example.dto.AdminDto;
import com.capgemini.example.dto.UserDto;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.AlreadyExistsException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.exception.InvalidEmailException;
import com.capgemini.example.exception.InvalidNameException;
import com.capgemini.example.exception.InvalidPasswordException;
import com.capgemini.example.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user)
			throws AlreadyExistsException, InvalidNameException, InvalidPasswordException, InvalidEmailException {
		return new ResponseEntity<User>(userService.userRegistration(user), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User loginRequest)
			throws InvalidEmailException, InvalidPasswordException {
		return new ResponseEntity<String>(userService.userLogin(loginRequest.getEmail(), loginRequest.getPassword()),
				HttpStatus.OK);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable("userId") int userId, @RequestBody User user)
			throws IdNotFoundException, InvalidNameException{
		return new ResponseEntity<User>(userService.updateUserById(userId, user), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId) throws IdNotFoundException {
		return new ResponseEntity<String>(userService.deleteUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/admin/get-users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	@GetMapping("/userDashboard/{userId}")
	public ResponseEntity<UserDto> userDashboard(@PathVariable("userId") int userId) throws IdNotFoundException{
		return new ResponseEntity<UserDto>(userService.getUserDashboard(userId),HttpStatus.OK);
	}
	@GetMapping("/get-user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) throws IdNotFoundException{
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody UserDto userDto)  throws InvalidPasswordException, InvalidEmailException{
		return new ResponseEntity<String>(userService.forgotUserPassword(userDto),HttpStatus.OK);
	}
	@PostMapping("/resetPassword/{userId}")
	public ResponseEntity<String> forgotPassword(@PathVariable("userId") int userId,@RequestBody UserDto userDto)  throws InvalidPasswordException, IdNotFoundException{
		return new ResponseEntity<String>(userService.resetUserPassword(userId,userDto),HttpStatus.OK);
	}
	
	@GetMapping("/adminDashboard/{userId}")
	public ResponseEntity<AdminDto> adminDashboard(@PathVariable("userId") int userId) throws IdNotFoundException{
		return new ResponseEntity<AdminDto>(userService.getAdminDashboard(userId),HttpStatus.OK);
	}
}
	
	


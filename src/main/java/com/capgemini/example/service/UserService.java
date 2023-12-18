package com.capgemini.example.service;

import java.util.List;

import com.capgemini.example.dto.AdminDto;
import com.capgemini.example.dto.UserDto;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.AlreadyExistsException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.exception.InvalidEmailException;
import com.capgemini.example.exception.InvalidNameException;
import com.capgemini.example.exception.InvalidPasswordException;

public interface UserService {

	
	
	List<User> getAllUsers();
	
	User updateUserById(int userid, User user) throws IdNotFoundException;
 
	User userRegistration(User user)
			throws AlreadyExistsException, InvalidNameException, InvalidPasswordException, InvalidEmailException;
	 String userLogin(String email, String password) throws InvalidEmailException, InvalidPasswordException;
	String forgotUserPassword(UserDto userDto) throws InvalidPasswordException, InvalidEmailException;
	String deleteUserById(int id) throws IdNotFoundException;
	String resetUserPassword(int userId, UserDto userDto) throws IdNotFoundException, InvalidPasswordException ;
	UserDto getUserDashboard(int userId) throws IdNotFoundException;
	User getUserById(int userId) throws IdNotFoundException;
	
	AdminDto getAdminDashboard(int userId) throws IdNotFoundException;
}

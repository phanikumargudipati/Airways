package com.capgemini.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.capgemini.example.dto.AdminDto;
import com.capgemini.example.dto.UserDto;
import com.capgemini.example.entity.Address;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.AlreadyExistsException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.exception.InvalidEmailException;
import com.capgemini.example.exception.InvalidNameException;
import com.capgemini.example.exception.InvalidPasswordException;
import com.capgemini.example.repository.AddressRepository;
import com.capgemini.example.repository.BookingRepository;
import com.capgemini.example.repository.UserRepository;
import com.capgemini.example.service.UserServiceImplementation;
 
public class UserServiceTest {
 
	@Mock
	private UserRepository userRepository;
 
	@Mock
	private AddressRepository addressRepository;
 
	@Mock
	private BookingRepository bookingRepository;
 
	@InjectMocks
	private UserServiceImplementation userService;
 
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
 
	@Test
	void testGetAllUsers() {
 
		User user1 = new User();
		User user2 = new User();
		List<User> userList = Arrays.asList(user1, user2);
 
		when(userRepository.findAll()).thenReturn(userList);
 
		List<User> result = userService.getAllUsers();
 
		assertEquals(2, result.size());
		verify(userRepository, times(1)).findAll();
	}
 
	@Test
	void testUserRegistration() {
		User user = new User();
		user.setEmail("test@example.com");
		user.setPassword("password");
		user.setFirstName("John");
		user.setLastName("Doe");
 
		when(userRepository.findByEmail("test@example.com")).thenReturn(null);
		when(userRepository.save(any())).thenReturn(user);
 
		assertDoesNotThrow(() -> userService.userRegistration(user));
 
		verify(userRepository, times(1)).findByEmail("test@example.com");
		verify(userRepository, times(1)).save(user);
	}
 
	@Test
	void testGetUserDashboard() throws IdNotFoundException {
 
		User user = new User();
		user.setUserId(1);
		user.setUserName("john_doe");
		user.setEmail("john@example.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setMobileNo(1234567890);
		user.setRole("user");
 
		when(userRepository.existsById(1)).thenReturn(true);
		when(userRepository.findByUserId(1)).thenReturn(user);
 
		UserDto result = userService.getUserDashboard(1);
 
		assertNotNull(result);
		assertEquals(user.getUserId(), result.getUserId());
		assertEquals(user.getUserName(), result.getUserName());
		assertEquals(user.getEmail(), result.getEmail());
		assertEquals(user.getFirstName(), result.getFirstName());
		assertEquals(user.getLastName(), result.getLastName());
		assertEquals(user.getMobileNo(), result.getMobileNo());
 
		verify(userRepository, times(1)).existsById(1);
		verify(userRepository, times(1)).findByUserId(1);
	}
 
	@Test
	void testGetAdminDashboard() throws IdNotFoundException {
 
		User user = new User();
		user.setUserId(1);
		user.setRole("admin");
 
		when(userRepository.existsById(1)).thenReturn(true);
		when(userRepository.findByUserId(1)).thenReturn(user);
 
		AdminDto result = userService.getAdminDashboard(1);
 
		assertEquals(user.getUserId(), result.getUserId());
		verify(userRepository, times(1)).existsById(1);
		verify(userRepository, times(1)).findByUserId(1);
	}
 
	@Test
	void testUserLogin_WhenCredentialsAreCorrect_ShouldReturnSuccessMessage()
			throws InvalidEmailException, InvalidPasswordException {
 
		String email = "john@example.com";
		String password = "password123";
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole("user");
 
		when(userRepository.findByEmail(email)).thenReturn(user);
 
		String result = userService.userLogin(email, password);
 
		assertNotNull(result);
		assertEquals("User Login Successfully", result);
		verify(userRepository, times(1)).findByEmail(email);
	}
 
	@Test
	void testUserLogin_WhenUserDoesNotExist_ShouldThrowInvalidEmailException()
			throws InvalidEmailException, InvalidPasswordException {
 
		String email = "john@example.com";
		String password = "password123";
 
		when(userRepository.findByEmail(email)).thenReturn(null);
 
		InvalidEmailException exception = assertThrows(InvalidEmailException.class, () -> {
			userService.userLogin(email, password);
		});
 
		assertEquals("INVALID_EMAIL", exception.getMessage());
 
		verify(userRepository, times(1)).findByEmail(email);
	}
 
	@Test
	void testUpdateUserById_WhenUserExists_ShouldReturnUpdatedUser() throws IdNotFoundException {
		int userId = 1;
		User existingUser = new User();
		existingUser.setUserId(userId);
		existingUser.setEmail("john@example.com");
		existingUser.setPassword("password123");
		existingUser.setFirstName("John");
		existingUser.setLastName("Doe");
		existingUser.setRole("user");
 
		User updatedUser = new User();
		updatedUser.setUserId(userId);
		updatedUser.setEmail("john.doe@example.com");
		updatedUser.setPassword("newPassword");
		updatedUser.setFirstName("Updated John");
		updatedUser.setLastName("Updated Doe");
 
		when(userRepository.existsById(userId)).thenReturn(true);
		when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
		when(userRepository.save(existingUser)).thenReturn(existingUser);
 
		User result = userService.updateUserById(userId, existingUser);
 
		assertNotNull(result);
		assertEquals(existingUser.getUserId(), result.getUserId());
		assertEquals(existingUser.getEmail(), result.getEmail());
		assertEquals(existingUser.getPassword(), result.getPassword());
		assertEquals(existingUser.getFirstName(), result.getFirstName());
		assertEquals(existingUser.getLastName(), result.getLastName());
		verify(userRepository, times(1)).existsById(userId);
		verify(userRepository, times(1)).findById(userId);
		verify(userRepository, times(1)).save(existingUser);
	}
 
	@Test
	void testUpdateUserById_WhenUserDoesNotExist_ShouldThrowIdNotFoundException() {
		int userId = 1;
		User updatedUser = new User();
		updatedUser.setUserId(userId);
		updatedUser.setEmail("john.doe@example.com");
		updatedUser.setPassword("newPassword");
		updatedUser.setFirstName("Updated John");
		updatedUser.setLastName("Updated Doe");
 
		when(userRepository.existsById(userId)).thenReturn(false);
 
		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
			userService.updateUserById(userId, updatedUser);
		});
 
		assertEquals("USER_ID_NOT_FOUND_INFO", exception.getMessage());
 
		verify(userRepository, times(1)).existsById(userId);
		verify(userRepository, never()).findById(userId);
		verify(userRepository, never()).save(updatedUser);
	}
	@Test
    void testDeleteUserById_WhenUserExists_ShouldReturnSuccessMessage() throws IdNotFoundException {
        int userId = 1;
 
    
        when(userRepository.existsById(userId)).thenReturn(true);
 
        String result = userService.deleteUserById(userId);
 
        assertNotNull(result);
        assertEquals("user Deleted Successfully", result);
 
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
 
    @Test
    void testDeleteUserById_WhenUserDoesNotExist_ShouldThrowIdNotFoundException() {
        int userId = 1;
 
        
        when(userRepository.existsById(userId)).thenReturn(false);
 
 
        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            userService.deleteUserById(userId);
        });
 
     
        assertEquals("USER_ID_NOT_FOUND_INFO", exception.getMessage());
 
        
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, never()).deleteById(userId);
    }
    @Test
    void testForgotUserPassword_WhenValidData_ShouldReturnSuccessMessage() throws InvalidPasswordException, InvalidEmailException {
 
        UserDto userDto = new UserDto();
        userDto.setEmail("john@example.com");
        userDto.setPassword("newPassword");
        userDto.setConfirmPassword("newPassword");
 
        User existingUser = new User();
        existingUser.setEmail("john@example.com");
 
        when(userRepository.findByEmail(userDto.getEmail())).thenReturn(existingUser);
        when(userRepository.save(existingUser)).thenReturn(existingUser);
 
        String result = userService.forgotUserPassword(userDto);
 
        assertEquals("Password Reset Successful", result);
 
        verify(userRepository, times(1)).findByEmail(userDto.getEmail());
        verify(userRepository, times(1)).save(existingUser);
    }
 
    @Test
    void testResetUserPassword_WhenValidData_ShouldReturnSuccessMessage() throws IdNotFoundException, InvalidPasswordException {
        int userId = 1;
        UserDto userDto = new UserDto();
        userDto.setPassword("newPassword");
        userDto.setConfirmPassword("newPassword");
 
        User existingUser = new User();
        existingUser.setUserId(userId);
 
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);
 
        String result = userService.resetUserPassword(userId, userDto);
 
     
        assertEquals("Password Reset Successful", result);
 
      
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(existingUser);
    }
 
 
}
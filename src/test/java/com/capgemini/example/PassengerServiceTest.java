package com.capgemini.example;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.repository.PassengerRepository;
import com.capgemini.example.service.PassengerServiceImplementation;
 
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PassengerServiceTest {
 
    @Mock
    private PassengerRepository passengerRepository;
 
    @InjectMocks
    private PassengerServiceImplementation passengerService;
 
    private Passenger testPassenger;
 
    @BeforeEach
    public void setup() {
        testPassenger = new Passenger();
        // Initialize other necessary objects for testing
    }
 
    @Test
    public void testAddPassenger_ShouldReturnSavedPassenger() {
        // Arrange
        Passenger passengerToSave = new Passenger(/* details to save */);
        Passenger savedPassenger = new Passenger(/* details after saving */);
        when(passengerRepository.save(passengerToSave)).thenReturn(savedPassenger);
 
        // Act
        Passenger result = passengerService.addPassenger(passengerToSave);
 
        // Assert
        assertEquals(savedPassenger, result);
    }
 
    @Test
    public void testGetPassenger_ShouldReturnAllPassengers() {
        // Arrange
        List<Passenger> myPassengers = new ArrayList<>();
        myPassengers.add(new Passenger(1,"John","J",25,'m',"Fs01","non-veg"));
        myPassengers.add(new Passenger(2,"Sen","s",24,'m',"Fs02","veg"));
        when(passengerRepository.findAll()).thenReturn(myPassengers);
 
        List<Passenger> result = passengerService.getPassenger();
 
        assertEquals(myPassengers, result);
    }
 
    @Test
    public void testGetPassenger_WhenNoPassengersExist_ShouldReturnEmptyList() {
        // Arrange
        when(passengerRepository.findAll()).thenReturn(new ArrayList<>());
 
        // Act
        List<Passenger> result = passengerService.getPassenger();
 
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
package com.capgemini.example;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Location;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.FlightNotFoundException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.repository.FlightRepository;
import com.capgemini.example.repository.LocationRepository;
import com.capgemini.example.repository.UserRepository;
import com.capgemini.example.service.FlightServiceImplementation;
 
 
@SpringBootTest
public class FlightServiceTest {
 
	@Mock
	private FlightRepository flightRepository;
	@Mock
	private UserRepository userRepository;
	@Mock
	LocationRepository locationRepository;

	@InjectMocks
	private FlightServiceImplementation flightServiceImplementation;
	 @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
	@Test
	public void  getAllFlightTest()
	{
		  List<Flight> flights = new ArrayList<Flight>();
		  Location location = new Location(1, "bangalore", "bhg", "india", "kemp");
		  flights.add(new Flight(1, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14), LocalTime.of(20, 30,35)), 30, location));
		  flights.add(new Flight(2, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14), LocalTime.of(20, 30,35)), 30, location));
		  when(flightRepository.findAll()).thenReturn(flights);
		  assertEquals(2, flightServiceImplementation.getFlights().size());
	}
	@Test
	public void addFligths() {
		 int userId = 3;
	        User adminUser = new User(userId,"admin"); // Assuming admin user
	        Location location = new Location(1, "bangalore", "bhg", "india", "kemp");
	        Flight flightToAdd = new Flight(1, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location);

 
	        when(userRepository.findById(userId)).thenReturn(Optional.of(adminUser));
	        when(locationRepository.existsById(location.getLocationId())).thenReturn(true);
	        when(locationRepository.findById(location.getLocationId())).thenReturn(Optional.of(location));
	        when(flightRepository.save(any(Flight.class))).thenReturn(flightToAdd);
 
	        // Act
	        Flight addedFlight =flightServiceImplementation.addFlights(userId,flightToAdd);
	        // Assert
	        assertEquals(flightToAdd, addedFlight);
	    }
	 @Test     //test cases for 
	    public void testUpdateFlight() throws IdNotFoundException, FlightNotFoundException {
	        // Arrange
	        int flightId = 1;
	        Location location = new Location(1, "bangalore", "bhg", "india", "kemp");
	        Flight existingFlight = new Flight(flightId, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location);
	        Flight updatedFlight = new Flight(flightId, "Chennai", "Bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location);
 
	        when(flightRepository.existsById(flightId)).thenReturn(true);
	        when(flightRepository.findById(flightId)).thenReturn(Optional.of(existingFlight));
	        when(flightRepository.save(any(Flight.class))).thenReturn(updatedFlight);
 
	        // Act
	        Flight result = flightServiceImplementation.updateFlight(flightId, updatedFlight);
 
	        // Assert
	        assertEquals(updatedFlight, result);
	    }
        //Test case for delete Flight
	 @Test
	    void testDeleteFlightById_WhenFlightExists_ShouldDeleteSuccessfully() throws IdNotFoundException, FlightNotFoundException {
	        // Arrange
	        int flightId = 1;
	        when(flightRepository.existsById(flightId)).thenReturn(true);
 
	        // Act
	        String result = flightServiceImplementation.deleteFlightById(flightId);
	        // Assert
	        verify(flightRepository,times(1)).deleteById(flightId);
	        assertEquals("flight deleted successfully",result);
	    }
 
	    @Test
	    void testDeleteFlightById_WhenFlightDoesNotExist_ShouldThrowIdNotFoundException() {
	        // Arrange
	        int flightId = 60;
	        when(flightRepository.existsById(flightId)).thenReturn(false);
 
	        // Act & Assert
	        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
	        	flightServiceImplementation.deleteFlightById(flightId);
	        });
 
	        // Assert
	        verify(flightRepository,never()).deleteById(anyInt());
	        assertEquals("USER_ID_NOT_FOUND_INFO", exception.getMessage());
	    }

	 //Testcase for search flight by location Id 
	 @Test
	    void testGetFlightsByLocationId_WhenFlightsExist_ShouldReturnFlightList() throws IdNotFoundException {
	        // Arrange
	        int locationId = 1;
	        List<Flight> myFlights = new ArrayList<>();
	        Location location = new Location(1, "bangalore", "bhg", "india", "kemp");
	        myFlights.add(new Flight(1, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location));
	        when(flightRepository.getAllFlightsByLocationId(locationId)).thenReturn(myFlights);
 
	        // Act
	        List<Flight> result = flightServiceImplementation.getFlightsByLocationId(locationId);
 
	        // Assert
	        assertEquals(myFlights, result);
	    }
 
	    @Test
	    void testGetFlightsByLocationId_WhenNoFlightsExist_ShouldThrowIdNotFoundException() {
	        // Arrange
	        int locationId = 1;
	        when(flightRepository.getAllFlightsByLocationId(locationId)).thenReturn(new ArrayList<>());
 
	        // Act & Assert
	        assertThrows(IdNotFoundException.class, () -> {
	        	flightServiceImplementation.getFlightsByLocationId(locationId);
	        });
	    }
	    @Test
	    public void testFindFlightsByFlightId() throws IdNotFoundException {
	        // Arrange
	        int flightId =1;
	        Location location = new Location(1, "bangalore", "bhg", "india", "kemp");
	        Flight expectedFlight = new Flight(flightId, "chennai", "bangalore", "bg01", "emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location);
	        // Mock the behavior of flightRepository
	        when(flightRepository.findFlightsByFlightId(flightId)).thenReturn(expectedFlight);
 
	        // Act
	        Flight actualFlight =flightServiceImplementation.findFlightsByFlightId(flightId);
 
	        // Assert
	        // Verify that the flightRepository method was called with the correct parameter
	        verify(flightRepository,times(1)).findFlightsByFlightId(flightId);
 
	        // Verify that the returned flight is not null
	        assertNotNull(actualFlight,"The returned flight should not be null");
 
	        // Verify that the returned flight is the same as the expected flight
	        assertEquals(actualFlight,expectedFlight);
	    }

	    @Test
	    void testFindFlightsByLocations() throws FlightNotFoundException {
	        // Arrange
	        String departureLocation = "Chennai";
	        String arrivalLocation = "Bangalore";
	        List<Flight> expectedFlights = new ArrayList<Flight>();
	        Location location = new Location(1, "Bangalore", "bhg", "india", "kemp");
	        expectedFlights.add(new Flight(1, "Chennai", "Bangalore", "bg01", "Emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location));
	        // Mock the behavior of flightRepository
	        when(flightRepository.findFlightsByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation))
	                .thenReturn(expectedFlights);
 
	        // Act
	        List<Flight> actualFlights =flightServiceImplementation.findFlightsByLocations(departureLocation, arrivalLocation);
 
	        // Assert
	        // Verify that the flightRepository method was called with the correct parameters
	        verify(flightRepository, times(1)).findFlightsByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation);
 
	        // Verify that the returned list is not empty
	        assertFalse(actualFlights.isEmpty(), "The list of flights should not be empty");
 
	        // Verify that the returned list is the same as the expected list
	        assertEquals(expectedFlights, actualFlights, "The returned list of flights should match the expected list");
	    }
	    @Test
	    void testFindFlightsByLocationsThrowsException() {
	        // Arrange
	    	String departureLocation = "Chennai";
	        String arrivalLocation = "Bangalore";
	        List<Flight> expectedFlights = new ArrayList<Flight>();
	        Location location = new Location(1, "Bangalore", "bhg", "india", "kemp");
	        expectedFlights.add(new Flight(1, "Chennai", "Bangalore", "bg01", "Emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location));
	        // Mock the behavior of flightRepository to return an empty list
	        when(flightRepository.findFlightsByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation))
	                .thenReturn(Arrays.asList());
 
	        // Act and Assert (this should throw FlightNotFoundException)
	        assertThrows(FlightNotFoundException.class,
	                () -> flightServiceImplementation.findFlightsByLocations(departureLocation, arrivalLocation),
	                "FlightNotFoundException should be thrown when no flights are found");
	    }
	    @Test
	    void testFindFlightsByDate() throws FlightNotFoundException {
	        // Arrange
	        LocalDateTime departureTime = LocalDateTime.now();
	        List<Flight> expectedFlights = Arrays.asList(new Flight(/* flight details go here */));
 
	        // Mock the behavior of flightRepository
	        when(flightRepository.findFlightsByDate(departureTime))
	                .thenReturn(expectedFlights);
 
	        // Act
	        List<Flight> actualFlights = flightServiceImplementation.findFlightsByDate(departureTime);
 
	        // Assert
	        // Verify that the flightRepository method was called with the correct parameter
	        verify(flightRepository, times(1)).findFlightsByDate(departureTime);
 
	        // Verify that the returned list is not empty
	        assertFalse(actualFlights.isEmpty(), "The list of flights should not be empty");
 
	        // Verify that the returned list is the same as the expected list
	        assertEquals(expectedFlights, actualFlights, "The returned list of flights should match the expected list");
	    }
 
	    @Test
	    void testFindFlightsByDateThrowsException() {
	        // Arrange
	        LocalDateTime departureTime = LocalDateTime.now();
 
	        // Mock the behavior of flightRepository to return an empty list
	        when(flightRepository.findFlightsByDate(departureTime))
	                .thenReturn(Arrays.asList());
 
	        // Act and Assert (this should throw FlightNotFoundException)
	        assertThrows(FlightNotFoundException.class,
	                () -> flightServiceImplementation.findFlightsByDate(departureTime),
	                "FlightNotFoundException should be thrown when no flights are found at the given time");
	    }
	    @Test
	    void testFindFlightsByLocationsAndDate() throws FlightNotFoundException {
	        // Arrange
	        String departureLocation = "Bangalore";
	        String arrivalLocation = "Chennai";
	        LocalDateTime departureTime = LocalDateTime.now();
	        List<Flight> expectedFlights = new ArrayList<Flight>();
	        Location location = new Location(1, "Bangalore", "bhg", "india", "kemp");
	        expectedFlights.add(new Flight(1, "Chennai", "Bangalore", "bg01", "Emirates", 40, 3000, LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(12, 45, 40)), LocalDateTime.of(LocalDate.of(2023, 12, 14),LocalTime.of(20, 30,35)), 30, location));

 
	        // Mock the behavior of flightRepository
	        when(flightRepository.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime))
	                .thenReturn(expectedFlights);
 
	        // Act
	        List<Flight> actualFlights = flightServiceImplementation.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime);
 
	        // Assert
	        // Verify that the flightRepository method was called with the correct parameters
	        verify(flightRepository, times(1)).findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime);
 
	        // Verify that the returned list is not empty
	        assertFalse(actualFlights.isEmpty(), "The list of flights should not be empty");
 
	        // Verify that the returned list is the same as the expected list
	        assertEquals(expectedFlights, actualFlights, "The returned list of flights should match the expected list");
	    }
 
	    @Test
	    void testFindFlightsByLocationsAndDateThrowsException() {
	        // Arrange
	        String departureLocation = "Bangalore";
	        String arrivalLocation = "Chennai";
	        LocalDateTime departureTime = LocalDateTime.now();
 
	        // Mock the behavior of flightRepository to return an empty list
	        when(flightRepository.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime))
	                .thenReturn(Arrays.asList());
 
	        // Act and Assert (this should throw FlightNotFoundException)
	        assertThrows(FlightNotFoundException.class,
	                () ->  flightServiceImplementation.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime),
	                "FlightNotFoundException should be thrown when no flights are found for the given locations and time");
	    }
 
}
package com.dagim.rs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagim.rs.entity.FlightEntity;
import com.dagim.rs.model.SearchFlights;
import com.dagim.rs.repository.FlightRepository;
import com.dagim.rs.utility.CalendarUtility;
import com.dagim.rs.exception.SeatsNotAvailableException;
import com.dagim.rs.exception.PassengerDetailNotFoundException;
import com.dagim.rs.model.Booking;
import com.dagim.rs.model.Passenger;
import com.dagim.rs.model.PassengerListContainer;

@Service
public class BookingService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public SearchFlights getFlightDetails(String flightId) throws Exception{
		
		SearchFlights result = new SearchFlights();
		FlightEntity flight = flightRepository.findOne(flightId);
		result.setAirlines(flight.getAirlines());
		result.setArrivalTime(flight.getArrivalTime());
		result.setDepartureTime(flight.getDepartureTime());
		result.setFare(flight.getFare().toString());
		result.setDestination(flight.getDestination());
		result.setFlightId(flight.getFlightId());
		result.setFlightAvailableDate(CalendarUtility.getStringFromCalendar(flight.getFlightAvailableDate()));
		result.setSeatCount(flight.getSeatCount().toString());
		return result;
		
	}
	
	public Booking bookTicket(Booking booking, PassengerListContainer passengerListContainer) throws PassengerDetailNotFoundException, SeatsNotAvailableException,Exception{

		if(passengerListContainer==null)
			throw new PassengerDetailNotFoundException("BookingService.PASSENGER_NOT_ADDED");
		List<Passenger> passengerList = passengerListContainer.getPassengerList();
		if(passengerList.size()==0||passengerList==null)
			throw new PassengerDetailNotFoundException("BookingService.PASSENGER_NOT_ADDED");
		FlightEntity flightEntity = flightRepository.findOne(booking.getFlightId());
		//check if there are any seats available
		if(flightEntity.getSeatCount() - passengerList.size() <= 0)
			throw new SeatsNotAvailableException("BookingService.SEATS_NOT_AVAILABLE");
		booking.setSeats(passengerList.size());
		Double totalFare = Double.parseDouble(booking.getFare()) * booking.getSeats();
		booking.setFare(totalFare.toString());
		Integer pnr = (int)Math.random() * 1858599;
		booking.setPnr(pnr);
		return booking;
	}
}

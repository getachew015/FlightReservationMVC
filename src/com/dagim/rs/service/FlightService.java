package com.dagim.rs.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dagim.rs.model.SearchFlights;
import com.dagim.rs.repository.FlightRepository;
import com.dagim.rs.utility.CalendarUtility;
import com.dagim.rs.entity.FlightEntity;
import com.dagim.rs.exception.ARSServiceException;
import com.dagim.rs.exception.FlightNotAvailableException;
import com.dagim.rs.exception.InvalidJourneyDateException;
import com.dagim.rs.exception.InvalidSourceDestinationException;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	protected String baseUrl;
	
	public List<String> getSources(){
		
		List<String> sources = flightRepository.findFlightSources();
		return sources;
	}
	
	public List<String> getDestination(){
		
		List<String> destinations = flightRepository.findFlightDestinations();
		return destinations;
	}
	
	public List<SearchFlights> getFlights(String source, String destination, Calendar journeyDate) throws  InvalidSourceDestinationException, FlightNotAvailableException, InvalidJourneyDateException, Exception{
		Calendar today = Calendar.getInstance();
		if(today.after(journeyDate))
			throw new InvalidJourneyDateException("FlightService.INVALID_JOURNEYDATE");
		if(source.equalsIgnoreCase(destination))
			throw new InvalidSourceDestinationException("FlightService.INVALID_SOURCE_DESTINATION");
		List<FlightEntity> flights = flightRepository.findFlights(source, destination, journeyDate);
		
		if(flights==null ||flights.isEmpty())
			throw new FlightNotAvailableException("FlightService.FLIGHT_NOT_AVAILABLE");

		List<SearchFlights> availableFlights = new ArrayList<SearchFlights>();
		
		for (FlightEntity f : flights) {
			SearchFlights flight = new SearchFlights();
			flight.setFlightId(f.getFlightId());
			flight.setSource(f.getSource());
			flight.setDestination(f.getDestination());
			flight.setJourneyDate(CalendarUtility.getStringFromCalendar(journeyDate));
			flight.setFlightAvailableDate(CalendarUtility.getStringFromCalendar(f.getFlightAvailableDate()));
			flight.setDepartureTime(f.getDepartureTime());
			flight.setArrivalTime(f.getArrivalTime());
			flight.setSeatCount(f.getSeatCount().toString());
			flight.setAirlines(f.getAirlines());
			flight.setFare(Double.toString(f.getFare()));
			availableFlights.add(flight);
		}
		return availableFlights;
	}
	
	public void updateFlightId(String flightId, String noOfSeats) throws ARSServiceException{
		
		FlightEntity flight = flightRepository.findOne(flightId);
		if(flight==null)
			throw new ARSServiceException("No flight for the given details");
		else{
			int count = flight.getSeatCount() - Integer.valueOf(noOfSeats);
			flight.setSeatCount(count);
			flightRepository.saveAndFlush(flight);
		}
	}
}

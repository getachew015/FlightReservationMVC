package com.dagim.rs.api;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dagim.rs.model.SearchFlights;
import com.dagim.rs.service.FlightService;
import com.dagim.rs.utility.CalendarUtility;


@RestController
@RequestMapping("FlightAPI")
public class FlightAPI {
	
	
	@Autowired
	private FlightService flightService;
	
	
	@RequestMapping(value="/{source}/{destination}/{journeyDate}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<SearchFlights>> getFlightDetails(@PathVariable String source, 
																@PathVariable String destination,
																@PathVariable String journeyDate) throws Exception{
		
		Calendar date = CalendarUtility.getCalendarFromString(journeyDate);
		List<SearchFlights> flights = flightService.getFlights(source, destination, date);
		return new ResponseEntity<List<SearchFlights>>(flights,HttpStatus.OK);
	}
	
	@RequestMapping(value="/source", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<String>> getSources() throws Exception {
		
		List<String> flightSources = flightService.getSources();
		return new ResponseEntity<List<String>> (flightSources, HttpStatus.OK);
	}
	
	@RequestMapping(value="/destination", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<String>> getDestination() throws Exception{

		List<String> flightDestination = flightService.getDestination();
		return new ResponseEntity<List<String>> (flightDestination, HttpStatus.OK);
	}
}

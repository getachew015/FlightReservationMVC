package com.dagim.rs.controller;

import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.rs.service.FlightService;
import com.dagim.rs.utility.CalendarUtility;
import com.dagim.rs.exception.FlightNotAvailableException;
import com.dagim.rs.exception.InvalidJourneyDateException;
import com.dagim.rs.exception.InvalidSourceDestinationException;
import com.dagim.rs.model.SearchFlights;

@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private Environment environment;

	@RequestMapping(value="/searchFlights", method = RequestMethod.POST)
	public ModelAndView searchFlights(@Valid @ModelAttribute("command") SearchFlights searchFlights,
			BindingResult result, ModelMap model) throws Exception{
		
		ModelAndView modelAndView = null;
		try {
			if(result.hasErrors()){
				modelAndView = new ModelAndView("searchFlights", "command", searchFlights);
			}
			else{
				
				String source = searchFlights.getSource();
				String destination = searchFlights.getDestination();
				Calendar journeyDate = CalendarUtility.getCalendarFromString(searchFlights.getJourneyDate());
				List<SearchFlights> availableFlights = flightService.getFlights(source, destination, journeyDate);
				model.addAttribute("availableFlights", availableFlights);
				model.addAttribute("size", availableFlights.size());
				modelAndView = new ModelAndView("searchFlights","command", searchFlights);
			}
		 } catch ( FlightNotAvailableException | InvalidJourneyDateException | InvalidSourceDestinationException   e) {
			if(e.getMessage().contains("FlightService"))
				modelAndView = new ModelAndView("searchFlights");
			
			modelAndView.addObject("searchFlights", environment.getProperty(e.getMessage()));

		}
		
		List<String> s1 = flightService.getSources();                
        model.addAttribute("sourceList", s1);
        
        //Select destination values from db
        List<String> s2 = flightService.getDestination();               
        model.addAttribute("destinationList", s2);
        
		return modelAndView;
		
	}
	
	@RequestMapping(value="/modifyBooking", method=RequestMethod.GET)
	public ModelAndView authenticateLogin(ModelMap model){
		//Get list of departure locations
		List<String> sourceList = flightService.getSources();
		model.addAttribute("sourceList", sourceList);
		//Get list of destination locations
		List<String> destinationList = flightService.getDestination();
		model.addAttribute("destinationList", destinationList);
		
		ModelAndView modelAndView = new ModelAndView("searchFlights","command", new SearchFlights());
		return modelAndView;
	}
}

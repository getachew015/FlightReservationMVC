package com.dagim.rs.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.rs.exception.SeatsNotAvailableException;
import com.dagim.rs.model.Booking;
import com.dagim.rs.model.CreditCard;
import com.dagim.rs.model.PassengerListContainer;
import com.dagim.rs.model.SearchFlights;
import com.dagim.rs.service.BookingService;
import com.dagim.rs.exception.PassengerDetailNotFoundException;

@Controller
@SessionAttributes({"booking","userId"})
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private Environment environment;
	private final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@RequestMapping(value="/bookFlight", method = RequestMethod.GET)
	public ModelAndView proceeed(ModelMap model, @RequestParam("flightid") String flightId,
								 HttpSession httpSession ) throws Exception{

		SearchFlights flight = bookingService.getFlightDetails(flightId);
		Booking booking = new Booking();

		booking.setDepartureDate(flight.getFlightAvailableDate());
		booking.setDepartureTime(flight.getDepartureTime());
		booking.setDestination(flight.getDestination());
		booking.setFare(flight.getFare());
		booking.setFlightId(flightId);
		booking.setSource(flight.getSource());
		booking.setAirlines(flight.getAirlines());
		booking.setSeats(Integer.parseInt(flight.getSeatCount()));
		booking.setName((String)httpSession.getAttribute("userId"));
		model.addAttribute(booking);
		httpSession.setAttribute("booking",booking);
		return new ModelAndView("bookingReview","command", booking);
	}
	
	@RequestMapping(value="/bookingProcess", method = RequestMethod.GET)
	public ModelAndView bookingProcess(ModelMap model, HttpSession session) throws Exception{
		
		PassengerListContainer passengerListContainer = (PassengerListContainer)session.getAttribute("passengerListContainer");
		Booking booking = (Booking) session.getAttribute("booking");
		ModelAndView modelAndView = new ModelAndView("payment","command",new CreditCard());
		
		try {
			
			booking = bookingService.bookTicket(booking, passengerListContainer);
			session.setAttribute("booking", booking);
			modelAndView.addObject("booking", booking);
			logger.info("********* PNR **********"+booking.getPnr());
			
		} catch (SeatsNotAvailableException | PassengerDetailNotFoundException e) {
			
			modelAndView = new ModelAndView("addPassengers");
			modelAndView.addObject("message",environment.getProperty(e.getMessage()));
			
		}
		return modelAndView;
	}
}

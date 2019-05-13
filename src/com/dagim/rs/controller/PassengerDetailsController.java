package com.dagim.rs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.dagim.rs.model.Passenger;
import com.dagim.rs.model.PassengerListContainer;
import com.dagim.rs.service.PassengerService;
import com.dagim.rs.exception.PassengerDetailNotFoundException;

@Controller
@SessionAttributes({"passengerListContainer","booking"})
public class PassengerDetailsController {
	
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private Environment environment;

	/* If the Http request method is not explicitly specified then the method 
	 * will resolve all types (GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE)
	 */
	@RequestMapping("/addPassengerDetails")
	public String addPassengers(ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value="f", required=false) String flush){
		
		if(flush!=null){
			session.setAttribute("passengerListContainer", getDummyPassengerListContainer());
		}
		if(session.getAttribute("passengerListContainer")==null){
			session.setAttribute("passengerListContainer", getDummyPassengerListContainer());
		}
		model.addAttribute("passengerListContainer", (PassengerListContainer)session.getAttribute("passengerListContainer"));
		session.setAttribute("contextPath", request.getContextPath());
		
		return "addPassengers";
		
	}
	
	@RequestMapping(value="/editPassengerListContainer", method=RequestMethod.POST)
	public String editPersonListContainer(@ModelAttribute PassengerListContainer personListContainer, ModelMap modelMap, 
			HttpSession session){
		
		String returnValue = "redirect:/bookingProcess";
		List<Passenger> passengerList = personListContainer.getPassengerList();
		session.setAttribute("passengerListContainer", passengerList);
		try {
			passengerService.validatePassengerDetails(passengerList);
	
		} catch (PassengerDetailNotFoundException e) {
			modelMap.addAttribute("message", environment.getProperty(e.getMessage()));
			return "addPassengers";
		}
		return returnValue;
	}
	
	public PassengerListContainer getDummyPassengerListContainer(){

		List<Passenger> passengerList = new ArrayList<Passenger>();
		
		for (int i = 0; i < 1; i++) {
			passengerList.add(new Passenger());
		}
		
		return new PassengerListContainer(passengerList);
	}
	
}

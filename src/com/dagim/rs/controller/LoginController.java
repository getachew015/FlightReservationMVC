package com.dagim.rs.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.rs.exception.InvalidCredentialException;
import com.dagim.rs.model.Login;
import com.dagim.rs.service.FlightService;
import com.dagim.rs.service.LoginService;
import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.model.SearchFlights;

@Controller
@SessionAttributes({"userName", "Id"})
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private Environment environment;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLoginDetails(){
		
		return new ModelAndView("login","command", new Login());
	}
	
	@RequestMapping(value="/authenticateLogin", method = RequestMethod.POST)
	public ModelAndView authenticateLogin(@Valid @ModelAttribute("command") Login userLogin, 
											BindingResult result, ModelMap model, 
											HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("error");
		try {
			if(result.hasErrors())
				modelAndView = new ModelAndView("login", "command", userLogin);
			else{
				UserEntity userEntity = loginService.authenticateLogin(userLogin);
				//System.out.println("customer name "+userEntity.getName());
				model.addAttribute("userName", userEntity.getName());
				model.addAttribute("userId", userEntity.getUserId());
				session.setAttribute("userId", userEntity.getUserId());
                //Select source values from db
                List<String> s1 = flightService.getSources();
                
                model.addAttribute("sourceList", s1);
                
                //Select destination values from db
                List<String> s2 = flightService.getDestination();               
                model.addAttribute("destinationList", s2);

                modelAndView = new ModelAndView("searchFlights", "command", new SearchFlights());	
			}
			
		} catch (InvalidCredentialException e) {
			if (e.getMessage().contains("LoginService")) {
				modelAndView = new ModelAndView("login"); 
				modelAndView.addObject("loginName", userLogin.getUserName());
			}
			modelAndView.addObject("message", environment.getProperty(e.getMessage()));
		}
		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView model = new ModelAndView("iTravelHome", "", "");

		Enumeration<String> attributes = session.getAttributeNames();

		while (attributes.hasMoreElements())
			session.removeAttribute(attributes.nextElement());
		
		model.addObject("logoutMessage", environment.getProperty("LoginController.LOGOUT_SUCCESS"));

		return model;
	}


}

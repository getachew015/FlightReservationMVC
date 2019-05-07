package com.dagim.rs.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.rs.exception.UserIdAlreadyPresentException;
import com.dagim.rs.model.User;
import com.dagim.rs.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Model model){
		//returning a string of view name, command string and model instance
		return new ModelAndView("register","command", new User());
	}
	
	@RequestMapping(value="registeruser", method = RequestMethod.POST)
	public ModelAndView addCustomer(@Valid @ModelAttribute("command") User user, BindingResult result,
			ModelMap model){
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors())
			modelAndView = new ModelAndView("register","command", user);
		else{
			try {
				registrationService.registerUser(user);
				modelAndView= new ModelAndView("register", "command", user);
				modelAndView.addObject("successMessage",environment.getProperty("RegistrationController.SUCCESSFUL_REGISTRATION"));			
			}catch(UserIdAlreadyPresentException e) {
				if (e.getMessage().contains("RegistrationService")) {
					modelAndView = new ModelAndView("register"); 
					modelAndView.addObject("command", user);
					modelAndView.addObject("message", environment.getProperty(e.getMessage()));		
				}
			}
		}
		return modelAndView;
	}

}

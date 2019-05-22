package com.dagim.rs.controller;

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
import com.dagim.rs.exception.UserNotFoundException;
import com.dagim.rs.model.Password;
import com.dagim.rs.service.PasswordService;


@Controller
public class PasswordController {
	
	
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private Environment environment;
	
	
	@RequestMapping(value="/forgotPassword")
	public ModelAndView intializeForm(){
		
		return  new ModelAndView("forgotPassword","fp", new Password());
		
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public ModelAndView updatePassword(@Valid @ModelAttribute Password passWord, 
			BindingResult result, ModelMap model){
		
		if(result.hasErrors())
			return new ModelAndView("forgotPassword","fp", passWord);
		
		int update;
		String email = passWord.getEmail();
		String phone = passWord.getPhone();
		String newPassWord = passWord.getNewPassword();
		
		try {
			
			update = passwordService.updatePassword(email, phone, newPassWord);
			if(update==1)
				model.addAttribute("successMessage", environment.getProperty("PasswordController.SUCCESSFUL_RESET"));
			return new ModelAndView("forgotPassword", "fp", passWord);
			
		} catch (UserNotFoundException e) {
			
			ModelAndView modelAndView = new ModelAndView("forgotPassword");
			model.addAttribute("message", environment.getProperty(e.getMessage()));
			return modelAndView;
			
		}
	}
	
	

}

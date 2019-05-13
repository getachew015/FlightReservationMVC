package com.dagim.rs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("contextPath")
@PropertySource("classpath:/com/dagim/rs/resources/configuration.properties")
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHomePageDetails(HttpSession session, HttpServletRequest request){
		logger.info("Check check mike check ........");
		session.setAttribute("contextPath", request.getContextPath());
		return new ModelAndView("iTravelHome","","");
		
	}
}

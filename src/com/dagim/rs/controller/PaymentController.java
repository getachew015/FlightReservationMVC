package com.dagim.rs.controller;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dagim.rs.service.PaymentService;
import com.dagim.rs.exception.CreditCardNotFoundException;
import com.dagim.rs.exception.InvalidCardDetailsException;
import com.dagim.rs.model.Booking;
import com.dagim.rs.model.CreditCard;


@Controller
@SessionAttributes("booking")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private Environment environment;

    @RequestMapping(value = "/makePayment", method = RequestMethod.POST)
    public ModelAndView  processPayment(@Valid @ModelAttribute("command") CreditCard creditCard, 
    																BindingResult bindingResult,
    										  ModelMap model, @RequestParam("fare") String fare, 
    										  			   HttpSession session) throws Exception {

	  ModelAndView modelAndView = new ModelAndView("paymentSuccess","command",creditCard);
	  
    	if(bindingResult.hasErrors()){
    		modelAndView= new ModelAndView("payment", "command",creditCard);
    	}
    	else{
    	
    	try {
			paymentService.findCreditCard(creditCard);
			paymentService.updateCreditCard(creditCard.getCardNumber(),fare);
			paymentService.confirmBooking(session);
			modelAndView.addObject("paymentMessage", environment.getProperty("PaymentController.PAYMENT_SUCCESS"));
			modelAndView.addObject("pnrMessage", environment.getProperty("PaymentController.PNR_DETAIL"));
		} catch (CreditCardNotFoundException | InvalidCardDetailsException e) {

			if (e.getMessage().contains("PaymentService")) 
				modelAndView = new ModelAndView("payment", "command",creditCard); 	

			modelAndView.addObject("message", environment.getProperty(e.getMessage()));
		}
    	catch(Exception e){
			throw e;
		}

    	}
    	
    	return modelAndView;
    	
    }
  
  
  @RequestMapping(value="/downloadTicket.pdf",  method = RequestMethod.GET)
  public void downloadTicket(Model model, HttpSession session) throws Exception {

      model.addAttribute("pnr", ((Booking)session.getAttribute("booking")).getPnr().toString());
      model.addAttribute("noOfSeats", ((Booking)session.getAttribute("booking")).getSeats().toString());
      model.addAttribute("user", ((Booking)session.getAttribute("booking")).getName());
      
  }

	

}

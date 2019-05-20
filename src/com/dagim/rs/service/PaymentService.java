package com.dagim.rs.service;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dagim.rs.entity.CreditCardEntity;
import com.dagim.rs.entity.FlightEntity;
import com.dagim.rs.entity.PassengerEntity;
import com.dagim.rs.entity.TicketEntity;
import com.dagim.rs.entity.UserEntity;
import com.dagim.rs.exception.CreditCardNotFoundException;
import com.dagim.rs.exception.InvalidCardDetailsException;
import com.dagim.rs.model.Booking;
import com.dagim.rs.model.CreditCard;
import com.dagim.rs.model.Passenger;
import com.dagim.rs.model.PassengerListContainer;
import com.dagim.rs.repository.CreditCardRepository;
import com.dagim.rs.repository.FlightRepository;
import com.dagim.rs.repository.PassengerRepository;
import com.dagim.rs.repository.TicketRepository;
import com.dagim.rs.repository.UserRepository;
import com.dagim.rs.utility.CalendarUtility;
import java.util.Calendar;
import java.util.List;

@Service
public class PaymentService {
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private TicketRepository ticketRepository;
				
	public void findCreditCard(CreditCard creditCard) throws CreditCardNotFoundException, InvalidCardDetailsException{
		CreditCardEntity ccEntity = creditCardRepository.findOne(creditCard.getCardNumber());

		if(ccEntity==null)
			throw new CreditCardNotFoundException("PaymentService.CREDITCARD_NOT_FOUND");
		
		if( ! (ccEntity.getCardHolderName().equalsIgnoreCase(creditCard.getCardHolderName()) &&
				ccEntity.getCardNumber().equals(creditCard.getCardNumber()) &&
				ccEntity.getCvv().equals(creditCard.getCvv()) &&
				ccEntity.getExpiryMonth().equalsIgnoreCase(creditCard.getExpiryMonth()) &&
				ccEntity.getExpiryYear().equals(creditCard.getExpiryYear())) )
			throw new InvalidCardDetailsException("PaymentService.CREDITCARD_NOT_FOUND");
	
	}
	
	public void updateCreditCard(String cardNumber, String fare){
		
		creditCardRepository.updateSeatCount(cardNumber,fare);
	}

	public void confirmBooking(HttpSession session) throws Exception{
		
		PassengerListContainer passengerListContainer = (PassengerListContainer) session.getAttribute("passengerListContainer");
		List<Passenger> passengerList = passengerListContainer.getPassengerList();
		Booking booking = (Booking) session.getAttribute("booking");
		UserEntity userEntity = userRepository.findOne(booking.getName());
		FlightEntity flightEntity = flightRepository.findOne(booking.getFlightId());
		flightRepository.updateSeatsDetails(booking.getFlightId(), booking.getSeats());
		TicketEntity tEntity = new TicketEntity();
		tEntity.setBookingDate(CalendarUtility.getStringFromCalendar(Calendar.getInstance()));
		tEntity.setDepartureDate(booking.getDepartureDate());
		tEntity.setDepartureTime(booking.getDepartureTime());
		tEntity.setNumOfSeats(booking.getSeats());		
		tEntity.setPnr(booking.getPnr().toString());
		tEntity.setUser(userEntity);
		tEntity.setFlight(flightEntity);
		tEntity.setTotalFare(booking.getFare());
		ticketRepository.saveAndFlush(tEntity);
		
		for (Passenger passenger : passengerList) {
			//For each passenger set the details
			PassengerEntity pe = new PassengerEntity();
			pe.setPassengerAge(passenger.getAge());
			pe.setPassengerGender(passenger.getGender());
			pe.setPassengerName(passenger.getPassengerName());
			TicketEntity t = ticketRepository.findOne(booking.getPnr().toString());
			pe.setTicket(t);
			pe=passengerRepository.saveAndFlush(pe);
		}

	}
}

package com.dagim.rs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dagim.rs.exception.PassengerDetailNotFoundException;
import com.dagim.rs.model.Passenger;

@Service
public class PassengerService {
	
	public void validatePassengerDetails(List<Passenger> passengerList) throws PassengerDetailNotFoundException{
		//validate if passenger details are stored correctly
		int count=0;
		for (Passenger passenger : passengerList) {
			if(passenger.getPassengerName()!=null && passenger.getPassengerName()!="")
				break;
			else
				count++;
		}
		//if the count for the empty passenger names is equal to the num of passengers it means there are no passenger details
		if(count==passengerList.size())
			throw new PassengerDetailNotFoundException("PassengerService.PASSENGER_NOT_FOUND");
	}
}

package com.dagim.rs.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FLIGHT_DETAILS")
public class FlightEntity {
	
	@Id
	private String flightId;
	private String airlines;
	private String source;
	private String destination;
	private Double fare;
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar flightAvailableDate;
	private String departureTime;
	private String arrivalTime;
	private Integer seatCount;
	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	/**
	 * @return the airlines
	 */
	public String getAirlines() {
		return airlines;
	}
	/**
	 * @param airlines the airlines to set
	 */
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}
	/**
	 * @return the flightAvailableDate
	 */
	public Calendar getFlightAvailableDate() {
		return flightAvailableDate;
	}
	/**
	 * @param flightAvailableDate the flightAvailableDate to set
	 */
	public void setFlightAvailableDate(Calendar flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}
	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the seatCount
	 */
	public Integer getSeatCount() {
		return seatCount;
	}
	/**
	 * @param seatCount the seatCount to set
	 */
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

}

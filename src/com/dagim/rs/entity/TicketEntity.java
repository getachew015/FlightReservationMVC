package com.dagim.rs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Ticket_Details")
public class TicketEntity {
	
	@Id
	private String pnr;
	private String bookingDate;
	private String departureDate;
	private String departureTime;
	private String totalFare;
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="flightId")
	private FlightEntity flight;
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="userId")
	private UserEntity user;
	private int numOfSeats;

	
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}
	public FlightEntity getFlight() {
		return flight;
	}
	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
}

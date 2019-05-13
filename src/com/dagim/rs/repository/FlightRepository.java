package com.dagim.rs.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dagim.rs.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, String> {
	
	@Query("select f from FlightEntity f where f.source=:source and f.destination=:dest and f.flightAvailableDate=:jDate and seatCount>0")
	List<FlightEntity> findFlights(@Param("source")String source, @Param("dest")String destination, @Param("jDate")Calendar date);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update FlightEntity set seatCount = seatCount-:noOfSeats where flightId=:flightId")
	void updateSeatsDetails(@Param("flightId")String flightId, @Param("noOfSeats")int noOfSeats);
	
	@Query("select f from FlightEntity f where f.flightId=:flightId")
	FlightEntity findFlight(@Param("flightId")String flightId);
	
	@Query("select distinct(f.source) from FlightEntity f")
	List<String> findFlightSources();
	
	@Query("select distinct(f.destination) from FlightEntity f")
	List<String> findFlightDestinations();
}

package com.dagim.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dagim.rs.entity.PassengerEntity;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Integer> {

}

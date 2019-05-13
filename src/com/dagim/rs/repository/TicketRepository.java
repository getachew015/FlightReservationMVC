package com.dagim.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dagim.rs.entity.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, String> {

}

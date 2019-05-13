package com.dagim.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dagim.rs.entity.CreditCardEntity;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, String>{

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="update CreditCardEntity set totalBill=totalBill+:fare where cardNumber=:cardNumber")
	void updateSeatCount(@Param("cardNumber") String cardNumber, @Param("fare") String fare);

}

package com.dagim.rs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CREDITCARD_DETAILS")
public class CreditCardEntity {
	
	@Id
	@NotEmpty(message="Card Number can not be empty")
	private String cardNumber;
	@NotEmpty(message="Card Holder name can not be empty")
	private String cardHolderName;
	@NotEmpty(message="CVV Number can not be empty")
	private String cvv;
	@NotEmpty(message="Expiry Month can not be empty")
	private String expiryMonth;
	@NotEmpty(message="Expiry Year can not be empty")
	private String expiryYear;
	@NotEmpty(message="Total Bill can not be empty")
	private String totalBill;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}	

}

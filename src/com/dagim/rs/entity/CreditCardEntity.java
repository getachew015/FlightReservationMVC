package com.dagim.rs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CREDICARD_DETAIL")
public class CreditCardEntity {
	@Id
	@NotEmpty(message="Card Number can not be empty")
	private String cardNumber;
	@NotEmpty(message="Card Holder name can not be empty")
	private String cardHolderName;
	@NotEmpty(message="CVV Number can not be empty")
	private String cvv;
	@NotEmpty(message="Pin can not be empty")
	private String securePin;
	@NotEmpty(message="Expiry Month can not be empty")
	private String expiryMonth;
	@NotEmpty(message="Expiry Year can not be empty")
	private String expirayYear;
	@NotEmpty(message="Total Bill can not be empty")
	private String totalBill;
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * @param cardHolderName the cardHolderName to set
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the securePin
	 */
	public String getSecurePin() {
		return securePin;
	}
	/**
	 * @param securePin the securePin to set
	 */
	public void setSecurePin(String securePin) {
		this.securePin = securePin;
	}
	/**
	 * @return the expiryMonth
	 */
	public String getExpiryMonth() {
		return expiryMonth;
	}
	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	/**
	 * @return the expirayYear
	 */
	public String getExpirayYear() {
		return expirayYear;
	}
	/**
	 * @param expirayYear the expirayYear to set
	 */
	public void setExpirayYear(String expirayYear) {
		this.expirayYear = expirayYear;
	}
	/**
	 * @return the totalBill
	 */
	public String getTotalBill() {
		return totalBill;
	}
	/**
	 * @param totalBill the totalBill to set
	 */
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	

}

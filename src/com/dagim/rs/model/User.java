package com.dagim.rs.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotEmpty(message="UserId can not be blank")
	@Size(min=5, max=30, message = "User Id should be between 5 and 30 characters")
	private String userId;
	@NotEmpty(message = "User Name can not be blank")
	@Size(min=3, max=50, message = "User name should be between 5 and 50 characters")
	private String name;
	@NotEmpty(message = "email can not be blank")
	@Size(min=5, max=50, message = "Email should be between 5 and 50 characters")	
	private String email;
	@NotEmpty(message = "PhoneNumber must not be blank.")
	@Size(min = 10, max = 10, message = "PhoneNumber must be 10 digits.")
	private String phone;
	@NotEmpty(message="Address must not be blank")
	private String address;
	@NotEmpty(message="Password can not be blank")
	@Size(min=8, max=15, message = "Password must be between 8 to 15 Characters.")
	private String password;
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

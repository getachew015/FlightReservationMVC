package com.dagim.rs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* Access Strategies in JPA and Hibernate (field-based access and property-based access)
 * If we use @Id annotation on the primary key then hibernate assumes using field based
 * if we use the @Id at the getter() method hibernate will use property based access method
 * And if we want to use both in combination we have to explicity specify useing @AccessType.FIELD or @AccessType.PROPERTY
*/


@Entity
@Table(name="USER_DETAILS")
public class UserEntity {
	
	@Id
	private String userId;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String password;

	public UserEntity(){
		
	}
	public UserEntity(String userId, String name, String address, String email, String phone, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

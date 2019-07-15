package com.sc.customer.trial.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "customer_address")
public class CustomerAddress{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6525014479232417518L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@JsonProperty("type")
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	CustomerAddressType type;

	@JsonProperty("addr-line1")
	@Column(name = "addr_line1")
	String addrLine1;

	@JsonProperty("addr-line2")
	@Column(name = "addr_line2")
	String addrLine2;

	@JsonProperty("addr-line3")
	@Column(name = "addr_line3")
	String addrLine3;
	
	@JsonProperty("addr-line4")
	@Column(name = "addr_line4")
	String addrLine4;
	
	@JsonProperty("country-code")
	@Column(name = "country_code")
	String countryCode;

	@JsonProperty("zipcode")
	@Column(name = "zipcode")
	String zipCode;

	@JsonProperty("state")
	@Column(name = "state")
	String state;

	@JsonProperty("city")
	@Column(name = "city")
	String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerAddressType getType() {
		return type;
	}

	public void setType(CustomerAddressType type) {
		this.type = type;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getAddrLine3() {
		return addrLine3;
	}

	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}

	public String getAddrLine4() {
		return addrLine4;
	}

	public void setAddrLine4(String addrLine4) {
		this.addrLine4 = addrLine4;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

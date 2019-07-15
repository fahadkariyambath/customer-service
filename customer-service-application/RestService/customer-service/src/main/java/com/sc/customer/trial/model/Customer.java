package com.sc.customer.trial.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "customer")
public class Customer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3331527144175330854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@JsonProperty("first-name")
	@Column(name = "first_name")
	String firstName;

	@JsonProperty("middle-name")
	@Column(name = "middle_name")
	String middleName;

	@JsonProperty("last-name")
	@Column(name = "last_name")
	String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	@JsonProperty("date-of-birth")
	@Column(name = "date_of_birth")
	Date dob;
	
	@JsonProperty("mobile-number")
	@Column(name = "mobile_number")
	String mobileNumber;
	
	@JsonProperty("gender")
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	CustomerGender gender;
	
	@JsonProperty("addresses")
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="address_id", referencedColumnName="id")
	List<CustomerAddress> customerAddress;

	@JsonProperty("customer-number")
	@Column(name = "customer_number")
	String customerNumber;

	@JsonProperty("country-of-birth")
	@Column(name = "country_of_birth")
	String birthCountry;
	
	@JsonProperty("country-of-residence")
	@Column(name = "country_of_residence")
	String residenceCountry;

	@JsonProperty("customer-segment")
	@Enumerated(EnumType.STRING)
	@Column(name = "customer_segment")
	CustomerSegment customerSegment;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerGender getGender() {
		return gender;
	}

	public void setGender(CustomerGender gender) {
		this.gender = gender;
	}

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public CustomerSegment getCustomerSegment() {
		return customerSegment;
	}

	public void setCustomerSegment(CustomerSegment customerSegment) {
		this.customerSegment = customerSegment;
	}
		
	
}

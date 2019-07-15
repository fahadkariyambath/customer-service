package com.sc.customer.trial.service;

import java.util.List;

import com.sc.customer.trial.model.Customer;

public interface CustomerService {

	  public List<Customer> getAll();
	  
	  public Customer create(Customer p);
	  
	  public Customer modify(String customerNumber, Customer p);
	  
	  public Customer findById(Long customerId);
	  
	  public Customer findByCustomerNumber(String customerNumber);
	  
	  public Customer delete(String customerNumber);
	  
}

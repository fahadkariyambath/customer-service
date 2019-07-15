package com.sc.customer.trial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.sc.customer.trial.model.Customer;
import com.sc.customer.trial.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll(){
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(customerList::add);
	    return customerList;
	}
	
	@Override
	public Customer create(Customer p) {
		if (p.getCustomerNumber() ==null || p.getCustomerNumber().isEmpty())
			throw new RuntimeException("Customer Number Not Present");
		Customer customer = findByCustomerNumber(p.getCustomerNumber());
		if (customer!=null)
			throw new RuntimeException("Customer Already Present");
		return save(p);
	}

	public Customer save(Customer p){
		return customerRepository.save(p);
	}
	
	@Override
	public Customer findById(Long customerId){
		return customerRepository.findById(customerId).orElse(null);
	}
	
	@Override
	public Customer findByCustomerNumber(String customerNumber){
		List<Customer> customer = customerRepository.findByCustomerNumber(customerNumber);
		return customer.isEmpty()?null : customer.get(0);
	}

	@Override
	public Customer delete(String customerNumber){
		Customer customer = findByCustomerNumber(customerNumber);
		if (customer==null)
			throw new RuntimeException("Customer Not Present");
		customerRepository.deleteById(customer.getId());
		return customer;
	}
	
	@Override
	public Customer modify(String customerNumber, Customer p) {
		if (!customerNumber.equals(p.getCustomerNumber()))
			throw new RuntimeException("Customer Number Inconsistent");
		Customer customer = findByCustomerNumber(customerNumber);
		if (customer==null)
			throw new RuntimeException("Customer Not Present");
		return save(p);
	}

}

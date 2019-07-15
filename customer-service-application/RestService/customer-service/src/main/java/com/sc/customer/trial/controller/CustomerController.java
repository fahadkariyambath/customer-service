package com.sc.customer.trial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.customer.trial.model.Customer;
import com.sc.customer.trial.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@GetMapping(path ="/api/customer")
	public ResponseEntity<List<Customer>> getCustomers() {
	    return ResponseEntity.ok(customerService.getAll());
	}
	
	@PostMapping(path ="/api/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
	    return ResponseEntity.ok(customerService.create(customer));
	}

	@PutMapping(path ="/api/customer/{customer-number}")
	public ResponseEntity<Customer> modifyCustomer(@PathVariable(name="customer-number",required=true)String customerNumber,@RequestBody Customer customer) {
	    return ResponseEntity.ok(customerService.modify(customerNumber,customer));
	}

	@DeleteMapping(path ="/api/customer/{customer-number}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(name="customer-number",required=true)String customerNumber) {
	    return ResponseEntity.ok(customerService.delete(customerNumber));
	}
	
}

package com.sc.customer.trial.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.sc.customer.trial.model.Customer;


@RestResource(exported=false)
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByCustomerNumber(String customerNumber);
}

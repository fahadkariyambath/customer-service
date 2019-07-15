package com.sc.customer.trial.test;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;






import com.sc.customer.trial.controller.CustomerController;
import com.sc.customer.trial.model.Customer;
import com.sc.customer.trial.repository.CustomerRepository;
import com.sc.customer.trial.service.CustomerService;
import com.sc.customer.trial.service.CustomerServiceImpl;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	@TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }
	
	@Autowired
    private CustomerService customerService;
 
    @MockBean
    private CustomerRepository customerRepository;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Before
    public void setUp() {
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_SUCCESS_CUST001");
        Mockito.when(customerRepository.save(any(Customer.class)))
          .thenReturn(cust);
    }
    
    @Test
    public void whenCreateCustNumberNull_thenExceptionThrown() {
    	exceptionRule.expect(RuntimeException.class);
    	exceptionRule.expectMessage("Customer Number Not Present");
        Customer cust = new Customer();
        customerService.create(cust);
     }
    
    @Test
    public void whenCreateCustAlreadyExists_thenExceptionThrown() {
    	exceptionRule.expect(RuntimeException.class);
    	exceptionRule.expectMessage("Customer Already Present");
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_001");
        customers.add(cust);
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        customerService.create(cust);
     }

    @Test
    public void whenCreateNewCustomer_thenSuccess() {
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_001");
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        assert(customerService.create(cust).getCustomerNumber().equals("SAMPLE_SUCCESS_CUST001"));
     }

    @Test
    public void whenModifyCustNumberInconsistent_thenExceptionThrown() {
    	exceptionRule.expect(RuntimeException.class);
    	exceptionRule.expectMessage("Customer Number Inconsistent");
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_001");
        customerService.modify("SAMPLE_002",cust);
     }

    @Test
    public void whenModifyCustNotExists_thenExceptionThrown() {
    	exceptionRule.expect(RuntimeException.class);
    	exceptionRule.expectMessage("Customer Not Present");
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_001");
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        customerService.modify("SAMPLE_001",cust);
     }

    @Test
    public void whenModifyExistingCustomer_thenSuccess() {
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_SUCCESS_CUST001");
        customers.add(cust);
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        assert(customerService.modify("SAMPLE_SUCCESS_CUST001",cust).getCustomerNumber().equals("SAMPLE_SUCCESS_CUST001"));
     }

    @Test
    public void whenDeleteCustNotExists_thenExceptionThrown() {
    	exceptionRule.expect(RuntimeException.class);
    	exceptionRule.expectMessage("Customer Not Present");
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_001");
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        customerService.delete("SAMPLE_001");
     }

    @Test
    public void whenDeleteExistingCustomer_thenSuccess() {
    	List<Customer> customers = new ArrayList<Customer>();
        Customer cust = new Customer();
        cust.setCustomerNumber("SAMPLE_SUCCESS_CUST001");
        customers.add(cust);
        Mockito.when(customerRepository.findByCustomerNumber(any(String.class)))
        .thenReturn(customers);
        assert(customerService.delete("SAMPLE_SUCCESS_CUST001").getCustomerNumber().equals("SAMPLE_SUCCESS_CUST001"));
     }
    
}



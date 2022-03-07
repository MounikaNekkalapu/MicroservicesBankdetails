package com.coforge.microservices.Customersservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.microservices.Customersservice.configuration.LimitConfiguration;
import com.coforge.microservices.Customersservice.model.Customer;
import com.coforge.microservices.Customersservice.model.CustomerAccounts;
import com.coforge.microservices.Customersservice.model.Transactions;
import com.coforge.microservices.Customersservice.service.CustomerService;
import com.coforge.microservices.Customersservice.service.CustomerServiceClient;


@SuppressWarnings({ "rawtypes", "unchecked" })


@RestController
@RequestMapping("/Customer")

public class CustomerController {

	@Autowired
	CustomerService service;

	@Autowired
	CustomerServiceClient template;
	
	@Autowired
	LimitConfiguration configuration;
	
	@PostMapping("/Managerservice")
	  public List<CustomerAccounts> getMicro2Instance()
	  {
		return template.All();
	  }

	
    @GetMapping("/CustomersAll")
    List<Customer> findAll() {
        return service.findAllCustomer();
    }

	
	@PostMapping("/add")
	public ResponseEntity<String> createCustomer(@RequestBody Customer Customer)
	{
		
		return new ResponseEntity(service.insertCustomer(Customer), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/Transactions/{ttype}/{amount}")
	public ResponseEntity<Optional<Transactions>> getNotesBynoteId(@PathVariable("ttype") String ttype, @PathVariable("amount") long amount ){
		
		return new ResponseEntity(service.findByttype(ttype,amount), HttpStatus.OK);
	}
	
	@PostMapping("/Transactions/{ttype}")
	public ResponseEntity<Optional<Transactions>> getNotesBynoteId(@PathVariable("ttype") String ttype ){
		
		return new ResponseEntity(service.findByttype(ttype), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsConfiguration() {
		
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}

	
}

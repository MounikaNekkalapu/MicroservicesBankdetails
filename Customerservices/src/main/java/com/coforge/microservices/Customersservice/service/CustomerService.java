package com.coforge.microservices.Customersservice.service;

import java.util.List;
import java.util.Optional;


import com.coforge.microservices.Customersservice.model.Customer;
import com.coforge.microservices.Customersservice.model.Transactions;


public interface CustomerService {
	public List<Customer> findAllCustomer();
	public String insertCustomer(Customer customer);
	public Optional<Transactions> findByttype(String ttype,long amount);
	public Optional<Transactions> findByttype(String ttype);
	
}

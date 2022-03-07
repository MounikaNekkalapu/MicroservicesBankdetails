package com.coforge.microservices.Customersservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.coforge.microservices.Customersservice.model.Customer;
import com.coforge.microservices.Customersservice.model.Transactions;
import com.coforge.microservices.Customersservice.repo.CustomerRepo;
import com.coforge.microservices.Customersservice.repo.TransactionRepo;


public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerRepo repo;
	
	@Autowired
	private TransactionRepo tranrepo;
	
	/*
	 * @Autowired RestTemplate template;
	 */
	@Override
	public String insertCustomer(Customer customer) {
		repo.save(customer);
		return "Inserted Successfully";
	}

	@Override
	public Optional<Transactions> findByttype(String ttype,
			long amount) {
		return tranrepo.findByttype(ttype,amount);
	}

	@Override
	public Optional<Transactions> findByttype(String ttype) {
		return tranrepo.findByttype(ttype);
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	
	}

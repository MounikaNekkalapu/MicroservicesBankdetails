package com.example.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manager.model.Customer;
import com.example.manager.model.CustomerAccounts;
import com.example.manager.model.Transactions;

import Services.ManagerFeignClient;
import Services.ManagerService;
@SuppressWarnings({ "rawtypes", "unchecked" })

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
    @Autowired  
    ManagerService service;
    
    @Autowired
    ManagerFeignClient template;
	
	@GetMapping("/all")
    public  ResponseEntity<List<CustomerAccounts>> findAllCustomerAccounts(){
    	return  new ResponseEntity(service.findAllCustomerAccounts(),HttpStatus.OK);
    	
    }
    
	@PostMapping("/CustomerService")
	  public List<Customer> getInstance()
	  {
		return template.All();
	  }

    
    @PostMapping("/createaccounttype")
    public ResponseEntity insertcustomer(CustomerAccounts CustomerAccounts){
		return new ResponseEntity(service.insertcustomer(CustomerAccounts), HttpStatus.CREATED);

    	
    }
    
    @PostMapping("/Transactions/{ttype}/{amount}/{cid}")
	public ResponseEntity<List<Transactions>> gettransaction(@PathVariable("ttype") String ttype, @PathVariable("amount") long amount,int id ){
		
		return new ResponseEntity(service.findByttype(ttype,amount,id), HttpStatus.OK);
	}
	
    
    @PostMapping("/Transactions/{ttype}")
	public ResponseEntity<List<Transactions>> getttpe(@PathVariable("ttype") String ttype ){
		return  new ResponseEntity(service.findByttype(ttype), HttpStatus.FOUND);
	}
	
    
    @DeleteMapping("/delete/{cid}")
    public ResponseEntity deletecustomer(@PathVariable("cid") int id){
		return new ResponseEntity(service.deletecustomer(id), HttpStatus.OK);

    	
    }

}

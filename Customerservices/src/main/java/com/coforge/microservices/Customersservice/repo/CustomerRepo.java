package com.coforge.microservices.Customersservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.microservices.Customersservice.model.Customer;



@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
	 @Query("select u from Customer u where u.cid=?1")
     public List<Customer>  findAll(int cid);
}

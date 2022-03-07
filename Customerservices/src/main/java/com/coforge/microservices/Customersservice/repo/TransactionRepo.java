package com.coforge.microservices.Customersservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.microservices.Customersservice.model.Transactions;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Integer>{
	 @Query("select u from Transactions u where u.cid=?1")
	 public Optional<Transactions> findByttype(String ttype, long amount);

	 public Optional<Transactions> findByttype(String ttype);
      
}

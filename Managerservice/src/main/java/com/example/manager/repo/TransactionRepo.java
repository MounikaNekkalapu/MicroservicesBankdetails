package com.example.manager.repo;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.manager.model.Transactions;



@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	 @Query("select u from Transaction u where u.cid=?1")
     public List<Transaction>  findAllCustomerAccounts(int cid);

	public List<Transactions> findAllById(String ttype);

	public List<Transactions> findBy(String ttype, long amt, int id);
}

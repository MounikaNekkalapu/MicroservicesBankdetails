package com.example.manager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.manager.model.CustomerAccounts;



@Repository
public interface ManagerRepo extends JpaRepository<CustomerAccounts,Integer>{
	
        @Query("select u from CustomerAccounts u where u.cid=?1")
        public List<CustomerAccounts>  findAllCustomerAccounts(int cid);
}

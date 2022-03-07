package com.coforge.microservices.Customersservice.service;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.coforge.microservices.Customersservice.configuration.LoadBalancerConfiguration;
import com.coforge.microservices.Customersservice.model.CustomerAccounts;



@FeignClient(name="Managerservice")
@LoadBalancerClient(name = "Managerservice",
configuration=LoadBalancerConfiguration.class)

public interface CustomerServiceClient {
	@PostMapping("manager/all")
	  public List<CustomerAccounts> All();

   
}

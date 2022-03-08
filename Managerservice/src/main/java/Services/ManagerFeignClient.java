package Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.manager.model.Customer;


@FeignClient(name="Customerservices")

public interface ManagerFeignClient {

	@PostMapping("Customer/CustomersAll")
	  public List<Customer> All();

 
}

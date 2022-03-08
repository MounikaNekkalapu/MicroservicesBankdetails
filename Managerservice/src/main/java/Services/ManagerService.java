package Services;

import java.util.List;
import java.util.Optional;

import com.example.manager.model.CustomerAccounts;
import com.example.manager.model.Transactions;

public interface ManagerService {

	public List<CustomerAccounts> findAllCustomerAccounts();
	public String insertcustomer(CustomerAccounts CustomerAccounts);
	public String deletecustomer(int cid);
	public List<Transactions> findByttype(String ttype);
	public List<Transactions> findByttype(String ttype,long amt,int id);

	
}

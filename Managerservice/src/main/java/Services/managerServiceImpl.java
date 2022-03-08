package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.manager.model.CustomerAccounts;
import com.example.manager.model.Transactions;
import com.example.manager.repo.ManagerRepo;
import com.example.manager.repo.TransactionRepo;


public class managerServiceImpl implements ManagerService{

	@Autowired
	ManagerRepo repo;
	
	@Autowired
	TransactionRepo transrepo;
	
	@Override
	public List<CustomerAccounts> findAllCustomerAccounts() {
		
		
		return repo.findAll();
	}

	@Override
	public String insertcustomer(CustomerAccounts CustomerAccounts) {
		 repo.save(CustomerAccounts);
		return "Inserted Successfully";

	}

	@Override
	public String deletecustomer(int cid) {
		repo.deleteById(cid);
		return "Delete Successfully";
	}

	@Override
	public List<Transactions> findByttype(String ttype) {
		return transrepo.findAllById(ttype);
	}

	@Override
	public List<Transactions> findByttype(String ttype, long amt,int id) {
		// TODO Auto-generated method stub
		return transrepo.findBy(ttype, amt,id);
	}

}

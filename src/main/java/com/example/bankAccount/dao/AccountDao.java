package com.example.bankAccount.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankAccount.model.Account;
@Repository
public interface AccountDao extends CrudRepository<Account, Integer>  {
	
	
	

}

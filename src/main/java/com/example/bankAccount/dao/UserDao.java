package com.example.bankAccount.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankAccount.model.User;
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	
	

}

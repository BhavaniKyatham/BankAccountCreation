package com.example.bankAccount.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankAccount.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	public Optional<User> findByCustomerIdAndPassword(int customerId, String password);

}

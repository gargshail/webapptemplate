package com.myapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myapp.domain.User;


public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByLname(String lname);
}

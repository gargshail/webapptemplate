package com.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.myapp.domain.User;
import com.myapp.events.AllUserEvent;
import com.myapp.events.RequestAllUserEvent;
import com.myapp.repositories.UserRepository;

public class UserEventHandler implements UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	PlatformTransactionManager txManager;
	
	@Override
	public AllUserEvent findAllUsers(RequestAllUserEvent event) {
		System.out.println("just before getting  user from repository");
		
		Iterable<User> iterable = repository.findAll();
		
		System.out.println("just after getting  user from repository");
		
		AllUserEvent aue = new AllUserEvent(iterable);
		return aue;
	}

	@Override
	public void addRandomUser() {
		User u = new User();
		u.setFname("Fname " +  Math.random());
		u.setLname("Lname " +  Math.random());
		repository.save(u);
		System.out.println("Saved");
		return;
	}

}

package com.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.events.AllUserEvent;
import com.myapp.events.RequestAllUserEvent;
import com.myapp.repositories.UserRepository;

public class UserEventHandler implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public AllUserEvent findAllUsers(RequestAllUserEvent event) {
		
		AllUserEvent aue = new AllUserEvent(repository.findAll());
		return aue;
	}

}

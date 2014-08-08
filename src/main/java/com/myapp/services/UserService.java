package com.myapp.services;

import org.springframework.stereotype.Service;

import com.myapp.events.AllUserEvent;
import com.myapp.events.RequestAllUserEvent;

@Service
public interface UserService {
	AllUserEvent findAllUsers(RequestAllUserEvent event);
}

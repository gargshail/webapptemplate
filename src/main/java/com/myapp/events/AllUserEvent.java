package com.myapp.events;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.myapp.domain.User;


public class AllUserEvent {
	private final List<User> users;
	
	
	public AllUserEvent(List<User> users) {
		this.users = Collections.unmodifiableList(users);
	}
	
	public Collection<User> getModules() {
		return users;
	}
}

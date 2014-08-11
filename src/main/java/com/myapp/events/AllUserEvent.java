package com.myapp.events;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.myapp.domain.User;


public class AllUserEvent {
	private final List<User> users ;
	
	
	public AllUserEvent(Iterable<User> itereable) {
		
		users = new LinkedList<User>();
		Iterator<User> itr = itereable.iterator();
		while(itr.hasNext()) {
			users.add(itr.next());
		}
	}
	
	public Collection<User> getUsers() {
		return users;
	}
}

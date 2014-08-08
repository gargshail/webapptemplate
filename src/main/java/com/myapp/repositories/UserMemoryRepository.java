package com.myapp.repositories;

import java.util.LinkedList;
import java.util.List;

import com.myapp.domain.User;

public class UserMemoryRepository implements UserRepository{
	List <User> users  = new LinkedList<User>();
	@Override
	public List<User> getUsers() {
		if(users == null) {
			User u = new User();
			u.setFname("fname1");
			u.setLname("lname1");
			users.add(u);
			
			u = new User();
			u.setFname("fname2");
			u.setLname("lname2");
			users.add(u);
			
			u = new User();
			u.setFname("fname3");
			u.setLname("lname3");
			users.add(u);
			
		}
		return users;
	}

}

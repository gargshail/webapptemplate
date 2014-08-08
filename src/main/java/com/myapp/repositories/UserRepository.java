package com.myapp.repositories;

import java.util.List;

import com.myapp.domain.User;


public interface UserRepository {
	List<User> getUsers();
}

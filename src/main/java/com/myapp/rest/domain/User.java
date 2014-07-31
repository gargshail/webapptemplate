package com.myapp.rest.domain;

public class User {
	String fname;
	String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public static User fromUser(com.myapp.domain.User domainUser){
		User u = new User();
		u.setFname(domainUser.getFname());
		u.setLname(domainUser.getLname());
		return u;
	}
} 

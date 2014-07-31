package com.myapp.domain;

public class User {
	String fname;
	String lname;
	String pwhash;
	String username;
	
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
	public String getPwhash() {
		return pwhash;
	}
	public void setPwhash(String pwhash) {
		this.pwhash = pwhash;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}

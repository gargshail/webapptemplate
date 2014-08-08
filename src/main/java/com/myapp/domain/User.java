package com.myapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="User")

public class User {
	
	@Id @GeneratedValue long id;
	
	@Column
	String fname;
	
	@Column
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

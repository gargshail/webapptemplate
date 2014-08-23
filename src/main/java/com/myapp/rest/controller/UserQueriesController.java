package com.myapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myapp.events.AddUserEvent;
import com.myapp.events.AllUserEvent;
import com.myapp.events.RequestAllUserEvent;
import com.myapp.rest.domain.User;
import com.myapp.services.UserService;

@Controller
@RequestMapping("/users")
public class UserQueriesController {
	

	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AllUserEvent getUsers() {
		System.out.println("getting all users");
		return userService.findAllUsers(new RequestAllUserEvent());
	}
   
	
    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUser(@PathVariable String id) {
      

      User user = new User();
       
       user.setFname("James " + id);
   
       user.setLname("Smith");
   
       return user;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/radd")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody

    public String addRandomUser() {
    	System.out.println("Adding random user");
    	userService.addRandomUser();
    	System.out.println(" done Adding random user");
    	return "Ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/add")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String addUser(@RequestBody AddUserEvent json){
    	return  json.toString();
    }
    
}

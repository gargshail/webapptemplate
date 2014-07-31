package com.myapp.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myapp.rest.domain.User;

@Controller
@RequestMapping("/users")
public class UserQueriesController {



    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUser(@PathVariable String id) {
       
      User user = new User();
       
       user.setFname("James " + id);
   
       user.setLname("Smith");
   
       return user;
    }

}

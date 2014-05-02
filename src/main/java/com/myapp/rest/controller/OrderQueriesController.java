package com.myapp.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/orders")
public class OrderQueriesController {



    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<String> getAllOrders() {
        List<String> orders = new ArrayList<String>();
	orders.add("one");
	orders.add("two");
	orders.add("three");
	orders.add("four");
	orders.add("five");
        return orders;
    }

}

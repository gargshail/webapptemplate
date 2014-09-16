package com.myapp.rest.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.myapp.domain.Message;
import com.myapp.domain.HelloMessage;

@Controller
public class MesssagingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(HelloMessage message) throws Exception {
     //   Thread.sleep(3000); // simulated delay
        return new Message("Hello, " + message.getName() + "!");
    }
    
}
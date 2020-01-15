package com.example.stompdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {



    @MessageMapping("/greet")
    public Greeting greet(String name) {
        return new Greeting(name);
    }

    static class Greeting {
        public String greet;

        public Greeting(String name) {
            this.greet = "Hello, " + name;
        }
    }

}

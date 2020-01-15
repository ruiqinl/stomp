package com.example.stompdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingRestController {

    @Autowired
    SimpMessagingTemplate template;


    @GetMapping(path = "/rest/greet/{name}")
    public void greet(@PathVariable String name) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("language", "eng");
//        Message<byte[]> msg = MessageBuilder.withPayload(name.getBytes()).setHeader("language", "eng".getBytes()).build();
        template.convertAndSend("/topic/greet", "payload", headers);
    }

}

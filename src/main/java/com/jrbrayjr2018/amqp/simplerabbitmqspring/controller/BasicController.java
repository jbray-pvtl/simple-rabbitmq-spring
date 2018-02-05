package com.jrbrayjr2018.amqp.simplerabbitmqspring.controller;

import com.jrbrayjr2018.amqp.simplerabbitmqspring.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BasicController {

    @Autowired
    RabbitMqService rabbitService;

    @RequestMapping( value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Map<String,String> home() {
        Map<String,String> result = new HashMap<>();
        String message = "You are in the basic rabbitmq messaging app";
        result.put("data", message);
        return result;
    }

    @RequestMapping( value = "/send", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Map<String,String> sendMessage() {
        Map<String,String> result = new HashMap<>();
        String message = "sent message";
        result.put("data", message);
        rabbitService.rabbitMqSendOperation();
        return result;
    }

    @RequestMapping( value = "/retrieve", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Map<String,String> retrieveMessage() {
        Map<String,String> result = new HashMap<>();
        //TODO add method call here
        return result;
    }
}

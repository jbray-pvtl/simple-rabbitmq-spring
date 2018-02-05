package com.jrbrayjr2018.amqp.simplerabbitmqspring.service;

import com.jrbrayjr2018.amqp.simplerabbitmqspring.configuration.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    ApplicationContext ctx;

    public RabbitMqService(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void rabbitMqSendOperation() {

        RabbitTemplate template = this.ctx.getBean(RabbitTemplate.class);
        template.convertAndSend(RabbitMqConfiguration.QUEUE_NAME, "A brand new message!");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ie) {
            System.err.println(ie.getCause());
        }
    }
}

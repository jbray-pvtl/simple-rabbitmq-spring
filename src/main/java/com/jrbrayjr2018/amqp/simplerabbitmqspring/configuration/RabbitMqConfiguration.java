package com.jrbrayjr2018.amqp.simplerabbitmqspring.configuration;


import com.jrbrayjr2018.amqp.simplerabbitmqspring.service.RabbitMqService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration implements RabbitListenerConfigurer {

    public static final String QUEUE_NAME = "BasicChicagoQueue";

    @Autowired
    private ConnectionFactory rabbitConnectionFactory;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setEndpointRegistry(basicRabbitListenerEndpointRegistry());
    }

    @Bean
    public Queue basicQueue() {
        return new Queue(RabbitMqConfiguration.QUEUE_NAME, true);
    }

    @Bean
    public Exchange basicExchange() {
        return new DirectExchange("basic.exchange", true, false);
    }

    @Bean
    public RabbitListenerEndpointRegistry basicRabbitListenerEndpointRegistry() {
        RabbitListenerEndpointRegistry registry = new RabbitListenerEndpointRegistry();
        if(registry.isRunning() == false) {
            registry.start();
        }
        registry.getListenerContainers();
        //TODO must be implemented for class to function
        return registry;
    }
}

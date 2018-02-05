package com.jrbrayjr2018.amqp.simplerabbitmqspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleRabbitmqSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRabbitmqSpringApplication.class, args);
	}
}

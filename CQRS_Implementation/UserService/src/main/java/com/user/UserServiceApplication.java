package com.user;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.hibernate.mapping.Subclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(UserServiceApplication.class, args);
		System.err.println("applicationContext:" + applicationContext);
		
	}

	
	@Bean
	public CommandBus commandBus() {
		
		return SimpleCommandBus.builder().build();
	}

	
	
	@Bean
	public CommandGateway commandGateway() {
		return DefaultCommandGateway.builder().commandBus(commandBus()).build();
	}

	
	
}

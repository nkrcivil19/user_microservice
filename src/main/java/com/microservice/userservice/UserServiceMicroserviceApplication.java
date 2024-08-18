package com.microservice.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceMicroserviceApplication.class, args);
	}

}

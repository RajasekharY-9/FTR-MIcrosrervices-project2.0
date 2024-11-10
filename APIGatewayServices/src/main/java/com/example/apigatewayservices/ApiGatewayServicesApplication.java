package com.example.apigatewayservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//The place where all the requests comes into this place and then it will navigate the request to each microservice
public class ApiGatewayServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServicesApplication.class, args);
	}

}

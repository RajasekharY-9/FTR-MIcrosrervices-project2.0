package com.transport.admin_server_ms2;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
//To monitor all microservices health,env variables,logs
//We will enable all actuator end points here
public class AdminServerMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerMs2Application.class, args);
	}

}

package com.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//Now I want to register my MS in ServiceRegistry for tracebility
//If we want the circuit breakers,retry logics we can add resilliance4j
@EnableDiscoveryClient
@CrossOrigin(origins = "*")
public class TerminalMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalMsApplication.class, args);
	}

}

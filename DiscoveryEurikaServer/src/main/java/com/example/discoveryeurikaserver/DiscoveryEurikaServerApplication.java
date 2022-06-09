package com.example.discoveryeurikaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Our service discovery class
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryEurikaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryEurikaServerApplication.class, args);
	}

}

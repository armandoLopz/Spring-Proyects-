package com.microservice.residents.microservice_residents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceResidentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceResidentsApplication.class, args);
	}

}

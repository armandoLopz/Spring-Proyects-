package com.microservice.apartments.microservice_apartments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceApartmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApartmentsApplication.class, args);
	}

}

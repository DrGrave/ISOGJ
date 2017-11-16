package com.vidnichuk.isogj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IsogjApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsogjApplication.class, args);
	}
}

package com.jm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsMp2ProviderMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMp2ProviderMovieServiceApplication.class, args);
	}

}

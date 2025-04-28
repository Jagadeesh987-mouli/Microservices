package com.jm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MsMp2AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMp2AdminServerApplication.class, args);
	}

}

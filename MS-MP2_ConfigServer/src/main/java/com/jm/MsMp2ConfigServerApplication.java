package com.jm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsMp2ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMp2ConfigServerApplication.class, args);
	}

}

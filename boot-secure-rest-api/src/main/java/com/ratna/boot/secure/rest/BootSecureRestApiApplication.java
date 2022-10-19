package com.ratna.boot.secure.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BootSecureRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSecureRestApiApplication.class, args);
	}

}

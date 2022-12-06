package com.boot.jenkins;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJenkinsApplication {

	public static Logger log = LoggerFactory.getLogger(BootJenkinsApplication.class);

	@PostConstruct
	public void init() {
		log.info("BootJenkinsApplication started .....");

	}

	public static void main(String[] args) {
		log.info("BootJenkinsApplication executed .....");
		SpringApplication.run(BootJenkinsApplication.class, args);
	}

}

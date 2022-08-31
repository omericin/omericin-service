package com.web.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PhoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneApplication.class, args);
	}

}

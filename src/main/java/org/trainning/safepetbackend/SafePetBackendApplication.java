package org.trainning.safepetbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class SafePetBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafePetBackendApplication.class, args);
	}

}

package io.kprosoftware.codechallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.kprosoftware.codechallenge.service.InitializationTest;

@SpringBootApplication
public class KprosoftwareApplication {

	@Autowired
	private InitializationTest initializationTest;

	public static void main(String[] args) {
		SpringApplication.run(KprosoftwareApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (evt) -> {

			initializationTest.initDB();

		};

	}
}

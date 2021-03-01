package com.wherex.coretech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wherex.coretech.model", "com.wherex.coretech.repository"})
public class CoretechApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoretechApplication.class, args);
	}
}

package com.wherex.coretech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductController.class)
public class CoretechApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoretechApplication.class, args);
	}
}

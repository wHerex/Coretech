package com.wherex.coretech;

import com.wherex.coretech.Product.Product;
import com.wherex.coretech.Product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoretechApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoretechApplication.class, args);
	}

}

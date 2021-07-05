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

	@Bean
	public CommandLineRunner initData(ProductRepository repository) {
		return (args) -> {
			// save a couple of customers
			String paulanerDesc = "Paulaner Hefe-Weissbier powstaje w naturalnym procesie górnej fermentacji, z użyciem bawarskich odmian chmielu, wyselekcjonowanych szczepów drożdży, wody głębinowej i słodu pszenicznego.";
			repository.save(new Product("CocaCola 0,25m", "Napój gazowany", 8L, 25L));
			repository.save(new Product("Fanta 0,25l", "Napój gazowany", 8L, 25L));
			repository.save(new Product("Paulaner 0,5l", paulanerDesc, 15L, 50L));
			repository.save(new Product("Jägermeister 0,7l", "Niemiecki likier ziołowo-korzenny o słodko-gorzkim smaku, zawierający 35% alkoholu.", 30L, 5L));
		};
	}
}

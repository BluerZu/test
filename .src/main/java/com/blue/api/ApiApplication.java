package com.blue.api;

import com.blue.api.classes.Product;
import com.blue.api.services.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class ApiApplication {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

//	@PostConstruct
	public void init() {
		productService.createProduct(new Product(1, "Manzana", 0.99f, LocalDate.of(2024, 4, 29), 100));
	}
}


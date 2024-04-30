package com.blue.api;

import com.blue.api.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
//
//	@GetMapping(path="/")
//	public List<String> getNames(){
//		return List.of(
//				"Alex",
//				"Name",
//				"Temp",
//				"John"
//		);
//	}

	@GetMapping(path="/")
	public List<Product> getName(){
		return List.of(
				new Product(1, "Manzana", 0.99f, LocalDate.of(2024, 4, 29), 100),
				new Product(2, "Naranja", 1.25f, LocalDate.of(2024, 4, 30), 75),
				new Product(3, "Plátano", 2.00f, LocalDate.of(2024, 5, 1), 50)
		);
	}

}


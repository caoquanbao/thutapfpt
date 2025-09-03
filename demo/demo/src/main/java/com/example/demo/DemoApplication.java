package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Insert sample data into H2 when app starts
    @Bean
    CommandLineRunner initData(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("Laptop", 1200));
            productRepository.save(new Product("Phone", 800));
            productRepository.save(new Product("Tablet", 600));
        };
    }
}

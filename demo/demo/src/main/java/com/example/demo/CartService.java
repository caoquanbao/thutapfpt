package com.example.demo.service;

import com.example.demo.Product;
import com.example.demo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public double calculateTotalPrice() {
        return productRepository.findAll()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}

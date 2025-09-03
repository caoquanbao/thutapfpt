package com.example.demo.controller;

import com.example.demo.Product;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Thêm sản phẩm
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return cartService.addProduct(product);
    }

    // Lấy tất cả sản phẩm
    @GetMapping("/products")
    public List<Product> getProducts() {
        return cartService.getAllProducts();
    }

    // Tính tổng tiền
    @GetMapping("/total")
    public double getTotalPrice() {
        return cartService.calculateTotalPrice();
    }
}

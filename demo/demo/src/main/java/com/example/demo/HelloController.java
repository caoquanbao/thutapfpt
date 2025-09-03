package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Đánh dấu đây là REST Controller
public class HelloController {

    @GetMapping("/hello")  // Xử lý GET request với URL /hello
    public String sayHello() {
        return "Hello World!";
    }
}

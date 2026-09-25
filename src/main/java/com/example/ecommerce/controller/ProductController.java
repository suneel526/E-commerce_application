package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Map<String, Object>> getProducts() {
        return List.of(
                Map.of("id", 1, "name", "Laptop", "price", 65000),
                Map.of("id", 2, "name", "Keyboard", "price", 2500),
                Map.of("id", 3, "name", "Mouse", "price", 1200)
        );
    }
}

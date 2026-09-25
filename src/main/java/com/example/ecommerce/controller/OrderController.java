package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public List<Map<String, Object>> getOrders() {
        return List.of(
                Map.of("id", 1001, "userId", 101, "productId", 1, "status", "CONFIRMED"),
                Map.of("id", 1002, "userId", 102, "productId", 2, "status", "SHIPPED")
        );
    }
}

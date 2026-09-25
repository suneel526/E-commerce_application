package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return List.of(
                Map.of("id", 101, "name", "Suneel", "email", "suneel@example.com"),
                Map.of("id", 102, "name", "Rahul", "email", "rahul@example.com")
        );
    }
}

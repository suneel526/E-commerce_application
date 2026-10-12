package com.example.ecommerce;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product(1, "Laptop", "Everyday laptop", new BigDecimal("799.99"), 12),
            new Product(2, "Headphones", "Wireless headphones", new BigDecimal("89.50"), 35),
            new Product(3, "Keyboard", "Mechanical keyboard", new BigDecimal("59.00"), 20)
    );

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(long id) {
        return products.stream()
                .filter(product -> product.id() == id)
                .findFirst();
    }
}

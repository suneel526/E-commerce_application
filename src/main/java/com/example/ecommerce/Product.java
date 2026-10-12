package com.example.ecommerce;

import java.math.BigDecimal;

public record Product(
        long id,
        String name,
        String description,
        BigDecimal price,
        int quantity
) {
}

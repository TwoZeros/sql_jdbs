package ru.twozeros.jdbctask1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.twozeros.jdbctask1.repository.ProductRepositrory;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepositrory productRepositrory;

    public String getProductName(String name) {
        return productRepositrory.getProductName(name);
    }

}

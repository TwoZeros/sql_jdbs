package ru.twozeros.jdbctask1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.twozeros.jdbctask1.service.ProductService;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/fetch-product")
    public String getProduct(@RequestParam("name") String name) {
        return productService.getProductName(name);
    }
}

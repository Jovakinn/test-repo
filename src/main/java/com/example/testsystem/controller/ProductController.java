package com.example.testsystem.controller;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;
import com.example.testsystem.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("getAll")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("find_by_users")
    List<Product> findProductsByUsers(@RequestBody List<User> users) {
        return productService.getProductsByUsers(users);
    }

    @PutMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping
    void deleteUser(Long id) {
        productService.deleteProduct(id);
    }
}

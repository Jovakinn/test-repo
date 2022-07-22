package com.example.testsystem.service.interfaces;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getProductsByUsers(List<User> users);
}

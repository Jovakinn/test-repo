package com.example.testsystem.service.interfaces;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getUsersByProducts(List<Product> products);
    void buyProduct(Long id, Product product);

    User saveUser(User user);

    void deleteUser(Long id);
}

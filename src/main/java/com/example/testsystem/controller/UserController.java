package com.example.testsystem.controller;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;
import com.example.testsystem.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("getAll")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("find_by_products")
    List<User> findUsersByProducts(@RequestBody List<Product> products) {
        return userService.getUsersByProducts(products);
    }

    @PostMapping
    public void buyProduct(@RequestParam Long id, @RequestParam Product product) {
        userService.buyProduct(id, product);
    }

    @PutMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping
    void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}

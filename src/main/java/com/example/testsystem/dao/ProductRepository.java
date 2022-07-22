package com.example.testsystem.dao;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
    List<Product> findProductsByUsers(List<User> users);
}

package com.example.testsystem.service.implementations;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;
import com.example.testsystem.exceptions.ProductNotFound;
import com.example.testsystem.dao.ProductRepository;
import com.example.testsystem.service.interfaces.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("getting all products");
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        log.info("saving a product");
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("deleting product with id: " + id);
        var product = productRepository.findProductById(id)
                        .orElseThrow(() -> new ProductNotFound("No product with such id"));
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProductsByUsers(List<User> users) {
        log.info("getting products by list of users");
        return productRepository.findProductsByUsers(users);
    }
}

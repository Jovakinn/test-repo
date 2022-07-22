package com.example.testsystem.service.implementations;

import com.example.testsystem.entities.Product;
import com.example.testsystem.entities.User;
import com.example.testsystem.exceptions.IllegalUserId;
import com.example.testsystem.exceptions.UserNotEnoughMoneyException;
import com.example.testsystem.dao.UserRepository;
import com.example.testsystem.service.interfaces.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("getting all users");
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByProducts(List<Product> products) {
        log.info("getting users by list of products");
        return userRepository.findUsersByProducts(products);
    }

    @SneakyThrows
    @Override
    public void buyProduct(Long id, Product product) {
        log.info("buying product");
        User user = getUser(id);
        var moneyLeft = user.getAmountMoney() - product.getPrice();
        moneyCheck(user, moneyLeft);
        user.setAmountMoney(moneyLeft);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to db", user.getFirstName());
        return userRepository.save(user);
    }

    @SneakyThrows
    @Override
    public void deleteUser(Long id) {
        log.info("deleting user {}", id);
        User user = getUser(id);
        userRepository.delete(user);
    }

    private User getUser(Long id) throws IllegalUserId {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new IllegalUserId("Incorrect id:" + id));
    }

    private void moneyCheck(User user, long moneyLeft) {
        if (moneyLeft < 0) {
            throw new UserNotEnoughMoneyException("Not enough money for user " + user.getId());
        }
    }
}

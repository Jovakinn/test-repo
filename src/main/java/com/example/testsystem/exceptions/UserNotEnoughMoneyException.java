package com.example.testsystem.exceptions;

public class UserNotEnoughMoneyException extends RuntimeException {
    public UserNotEnoughMoneyException(String message) {
        super(message);
    }
}

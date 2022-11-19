package com.example.demo.exception;

public class customerException extends RuntimeException {
    public customerException (Long id) {
        super(String.format("Customer with id %s is not found", id));
    }
}

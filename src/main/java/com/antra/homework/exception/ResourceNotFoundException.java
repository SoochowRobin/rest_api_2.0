package com.antra.homework.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super("User has not found in Database!");
    }
}

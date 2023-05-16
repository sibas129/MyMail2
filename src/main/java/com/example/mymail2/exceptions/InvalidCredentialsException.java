package com.example.mymail2.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException (String message) {
        super(message);
    }
}

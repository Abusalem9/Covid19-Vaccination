package com.covid.vaccination.Exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }

    InvalidPasswordException() {

    }
}

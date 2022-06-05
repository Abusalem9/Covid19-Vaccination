package com.covid.vaccination.Exception;

public class InvalidMobileException extends RuntimeException {
    public InvalidMobileException(String message) {

        super(message);
    }

    InvalidMobileException() {

    }
}

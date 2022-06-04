package com.covid.vaccination.Exception;

public class UserAlreadyExistWithMobileNumber extends RuntimeException {

    public UserAlreadyExistWithMobileNumber(String message) {
        super(message);
    }

    UserAlreadyExistWithMobileNumber() {

    }

}

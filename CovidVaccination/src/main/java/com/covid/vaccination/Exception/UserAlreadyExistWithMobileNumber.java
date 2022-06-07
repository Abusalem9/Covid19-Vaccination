package com.covid.vaccination.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExistWithMobileNumber extends RuntimeException {

    public UserAlreadyExistWithMobileNumber(String message) {
        super(message);
    }

}

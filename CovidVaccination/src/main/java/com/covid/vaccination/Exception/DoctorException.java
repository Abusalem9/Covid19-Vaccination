package com.covid.vaccination.Exception;

public class DoctorException extends RuntimeException {

    public DoctorException() {
    }

    public DoctorException(String message) {
        super(message);
    }
}

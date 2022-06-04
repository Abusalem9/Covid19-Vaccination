package com.covid.vaccination.Exception;

public class AddressException extends RuntimeException {
    AddressException(){
    }
    public AddressException(String message){
        super(message);
    }
}

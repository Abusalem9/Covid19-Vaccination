package com.covid.vaccination.Exception;

public class IdProofException extends RuntimeException {
    IdProofException(){

    }
    public IdProofException(String message){
        super(message);
    }
}

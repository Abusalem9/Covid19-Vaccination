package com.covid.vaccination.Exception;

public class DoseException extends RuntimeException{

    public DoseException(){

    }
    public DoseException(String message){
    super(message);
    }
}

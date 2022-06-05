package com.covid.vaccination.Exception;

import com.covid.vaccination.Entity.MyErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler({InvalidMobileException.class})
    public ResponseEntity<MyErrorDetails> handleInvalidMobileException(InvalidMobileException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserException.class})
    public ResponseEntity<MyErrorDetails> handleUserException(UserException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<MyErrorDetails> handleInvalidPasswordException(InvalidPasswordException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({UserAlreadyExistWithMobileNumber.class})
    public ResponseEntity<MyErrorDetails> handleUserAlreadyExistWithMobileNumber(UserAlreadyExistWithMobileNumber exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler({AddressException.class})
    public ResponseEntity<MyErrorDetails> handleAddressException(AddressException exp, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        System.out.println("Wrong Request");

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.METHOD_NOT_ALLOWED);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myExpHandlerMain(Exception ie, WebRequest wr) {
        System.out.println("Please enter correct Details");


        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));


        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }
}


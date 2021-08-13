package com.everis.creditcardservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import javax.validation.ConstraintViolationException;
import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

    //handling custom validation errors
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> customeValidationErrorHandling(ConstraintViolationException exception) {
        var errorDetails = new ErrorDetails(
                new Date(),
                "Validation error",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CreditCardNotFoundException.class)
    public ResponseEntity<?> creditCardNotFoundErrorHandling(CreditCardNotFoundException exception) {
        var errorDetails = new ErrorDetails(
                new Date(),
                "Credit card not found",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST );
    }
}

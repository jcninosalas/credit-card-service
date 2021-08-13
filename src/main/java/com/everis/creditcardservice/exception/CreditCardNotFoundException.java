package com.everis.creditcardservice.exception;

public class CreditCardNotFoundException extends RuntimeException{

    public CreditCardNotFoundException() {
        super("No se encontraron registros");
    }
}

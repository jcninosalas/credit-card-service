package com.everis.creditcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class CreditCardResponse {

    private String message;
    private Map<String, Object> body;
}

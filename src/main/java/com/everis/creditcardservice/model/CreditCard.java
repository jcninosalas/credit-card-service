package com.everis.creditcardservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document
public class CreditCard {

    @Id
    private String id;
    private String carNumber;
    private LocalDate expirationDate;
    private String ccv;
    private String cardHolder;
}

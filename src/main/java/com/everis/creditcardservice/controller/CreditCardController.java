package com.everis.creditcardservice.controller;

import com.everis.creditcardservice.model.CreditCard;
import com.everis.creditcardservice.model.CreditCardResponse;
import com.everis.creditcardservice.service.CreditCardService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/credit-cards")
@Validated
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @PostMapping
    public Mono<CreditCardResponse> newCreditLine(
            @RequestParam @Size(min = 8, max = 11, message = "Minimo 8 maximo 11 digitos") String cardHolder) {
        return service.save(cardHolder);
    }

    @GetMapping
    public Flux<CreditCard> getAll (
            @RequestParam @Size(min = 8, max = 11, message = "Minimo 8 maximo 11 digitos") String cardHolder) {
        return service.findAll(cardHolder);
    }

    @GetMapping("/credit-card")
    public Mono<CreditCard> findById(@RequestParam String id) {
        return service.findById(id);
    }
}

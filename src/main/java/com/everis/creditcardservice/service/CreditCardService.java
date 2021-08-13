package com.everis.creditcardservice.service;

import com.everis.creditcardservice.model.CreditCard;
import com.everis.creditcardservice.model.CreditCardResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    Mono<CreditCardResponse> save(String cardHolder);

    Flux<CreditCard> findAll(String cardHolder);

    Mono<CreditCard> findById(String id);

}

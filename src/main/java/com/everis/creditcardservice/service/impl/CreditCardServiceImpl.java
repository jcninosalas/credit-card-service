package com.everis.creditcardservice.service.impl;

import com.everis.creditcardservice.exception.CreditCardNotFoundException;
import com.everis.creditcardservice.model.CreditCard;
import com.everis.creditcardservice.model.CreditCardResponse;
import com.everis.creditcardservice.repository.CreditCardRepository;
import com.everis.creditcardservice.service.CreditCardService;
import com.everis.creditcardservice.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Function;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository repository;

    @Override
    public Mono<CreditCardResponse> save(String cardHolder) {
        return repository.insert(Utils.generateCreditCard(cardHolder))
                .flatMap(creditCardResponse);
    }

    @Override
    public Flux<CreditCard> findAll(String cardHolder) {
        return repository.findAllByCardHolder(cardHolder)
                .switchIfEmpty(Mono.error(new CreditCardNotFoundException()));
    }

    @Override
    public Mono<CreditCard> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new CreditCardNotFoundException()));
    }

    private final Function<CreditCard, Mono<CreditCardResponse>> creditCardResponse = creditCard ->
            Mono.just(new CreditCardResponse(
                    "Operacion realizada con exito",
                    Map.of("creditCard", creditCard)
            ));
}

package com.everis.creditcardservice.handler;

import com.everis.creditcardservice.model.CreditCard;
import com.everis.creditcardservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class CreditCardHandler {

    @Autowired
    private CreditCardRepository repository;

    public Mono<ServerResponse> getAllCreditCards(ServerRequest request) {
        var cardList = repository.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(cardList, CreditCard.class);
    }

    public Mono<ServerResponse> findCardById(ServerRequest request) {
        return repository.findById(request.pathVariable("id")).
                flatMap( creditCard -> ServerResponse.ok().body(creditCard, CreditCard.class));
    }

    public Mono<ServerResponse> saveCreditCard (ServerRequest request) {
        return request.bodyToMono(CreditCard.class)
                .flatMap(creditCard -> ServerResponse.ok().body(repository.save(creditCard), CreditCard.class));
    }
}

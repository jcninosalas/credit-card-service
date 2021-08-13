package com.everis.creditcardservice.repository;

import com.everis.creditcardservice.model.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {

    Flux<CreditCard> findAllByCardHolder(String cardHolder);
}

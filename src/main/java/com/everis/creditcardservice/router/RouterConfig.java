package com.everis.creditcardservice.router;

import com.everis.creditcardservice.handler.CreditCardHandler;
import com.everis.creditcardservice.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CreditCardHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/credit-cards", handler::getAllCreditCards)
                .GET("/credit-cards/{id}", handler::findCardById)
                .POST("/credit-cards/save",handler::saveCreditCard)
                .build();

    }
}

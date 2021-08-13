package com.everis.creditcardservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Document
public class CreditCard {

    @Id
    private String id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String carNumber;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate expirationDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ccv;

    @NotNull
    @Size(min = 8, message = "El numero de documento requiere minimo 8 digitos")
    @Pattern(regexp = "^[0-9]*$", message = "El numero de documento solo acepta numeros")
    private String cardHolder;

    private BigDecimal creditLineAmmount;
}

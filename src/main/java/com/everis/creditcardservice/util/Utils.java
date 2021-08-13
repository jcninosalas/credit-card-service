package com.everis.creditcardservice.util;

import com.everis.creditcardservice.model.CreditCard;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {

    private static String generateAccountNumber() {
        final String SAVINGS_ACCOUNT_PREFIX = "4100";
        Random random = new Random();
        return SAVINGS_ACCOUNT_PREFIX + random.nextInt(99999999) + random.nextInt(9999);
    }

    private static String generateCCVNumber() {
        Random random = new Random();
        return String.valueOf(random.nextInt(999));
    }

    private static LocalDate calculateExpirationDate() {
        var timeZone = ZoneId.systemDefault();
        var today = new Date().toInstant().atZone(timeZone).toLocalDate();
        return today.plusYears(2);
    }

    public static CreditCard generateCreditCard(String documentNumber) {
        var creditCard = new CreditCard();
        creditCard.setCarNumber(generateAccountNumber());
        creditCard.setCcv(generateCCVNumber());
        creditCard.setExpirationDate(calculateExpirationDate());
        creditCard.setCardHolder(documentNumber);
        creditCard.setCreditLineAmmount(new BigDecimal(0));
        return creditCard;
    }

}

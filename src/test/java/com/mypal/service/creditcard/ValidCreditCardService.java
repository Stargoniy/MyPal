package com.mypal.service.creditcard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidCreditCardService {
    @Test
    public void shouldValidCardInfo() {

        com.mypal.service.CreditCard.ValidCreditCardService isValidCard = new com.mypal.service.CreditCard.ValidCreditCardService();

        assertEquals(0, isValidCard.validateCardInfo("4929314454012076", "0", "Example", "112", "09").size());
        assertEquals(3, isValidCard.validateCardInfo("1111111111111117", "0n", "_1_#", "112", "09").size());

    }
}

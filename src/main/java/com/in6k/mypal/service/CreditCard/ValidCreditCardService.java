package com.in6k.mypal.service.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class ValidCreditCardService {
    private final static String VALID_SUM = "[-+]?(?:\\b[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+\\b)(?:[eE][-+]?[0-9]+\\b)?";
    private final static String VALID_NAME = "[A-Z]([a-z]+|\\s[a-z]+)";
    private final static String VALID_CVV = "/^[0-9]{3,4}$/";
    private final static String VALID_MONTH = "/(0[1-9]|1[012])/";
    private final static String VALID_CREDIT_CARD_NUMBER = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";

    private boolean isSumValid(String sum) {
        return sum.matches(VALID_SUM);
    }

    private boolean isNameValid(String name) {
        return name.matches(VALID_NAME);
    }

    private boolean isCvvValid(String cvv) {
        return cvv.matches(VALID_CVV);
    }

    private boolean isMonthValid(String month) {
        return month.matches(VALID_MONTH);
    }

    public List validateCardInfo(String cardNumber, String sumOnCard, String cardName, String cvv, String cardMonth){
        List result = new ArrayList();

        if(!validateTypeCard (cardNumber)) {
            result.add("cardNumber");
        }

        if(!isSumValid (sumOnCard)) {
            result.add("sum");
        }

        if(!isNameValid (cardName)) {
            result.add("cardName");
        }

        /*if(!isCvvValid (cvv)) {
            result.add("cvv");
        }

        if(!isMonthValid (cardMonth)) {
            result.add("cardMonth");
        }
*/
        return result;
    }

    public boolean isValidCardNumber (String cardNumber) {
        String digitsOnly = cardNumber;
        int sum = 0;
        int digit = 0;
        int addend = 0;
        boolean timesTwo = false;

        for (int i = digitsOnly.length () - 1; i >= 0; i--) {
            digit = Integer.parseInt (digitsOnly.substring (i, i + 1));
            if (timesTwo) {
                addend = digit * 2;
                if (addend > 9) {
                    addend -= 9;
                }
            } else {
                addend = digit;
            }
            sum += addend;
            timesTwo = !timesTwo;
        }

        int modulus = sum % 10;
        return modulus == 0;
    }

    private boolean validateTypeCard(String number) {
        boolean result = false;

        if (number.matches(VALID_CREDIT_CARD_NUMBER)){
            result = isValidCardNumber(number);
        }
        return result;
    }

}

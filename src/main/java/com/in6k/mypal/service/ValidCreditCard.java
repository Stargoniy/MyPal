package com.in6k.mypal.service;

import java.util.ArrayList;
import java.util.List;

public class ValidCreditCard {
    /*private final static String VALID_SUM = "[-+]?(?:\\b[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+\\b)(?:[eE][-+]?[0-9]+\\b)?";

    private boolean isSumValid(String sum) {
        return Double.toString(sum).matches(VALID_SUM);
    }*/

    public List validateCardInfo(String cardNumber, String expiry, String name, double sumOnCard, String cvvOnCard, String cardType){
        List result = new ArrayList();

        if(!validateTypeCard (cardNumber, cardType)) {
            result.add("cardNumber");
        }

        return result;
    }

    private String getDigitsOnly (String s) {
        StringBuffer digitsOnly = new StringBuffer ();
        char c;

        for (int i = 0; i < s.length (); i++) {
            c = s.charAt (i);
            if (Character.isDigit (c)) {
                digitsOnly.append (c);
            }
        }

        return digitsOnly.toString ();
    }

    public boolean isValidCardNumber (String cardNumber) {
        String digitsOnly = getDigitsOnly( cardNumber );
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

    private boolean validateTypeCard(String number, String type) {

        String s = type.toLowerCase();
        if (s.equals("mastercard")) {
            if (number.length() != 16 ||
                    Integer.parseInt(number.substring(0, 2)) < 51 ||
                    Integer.parseInt(number.substring(0, 2)) > 55) {
                return false;
            }

        } else if (s.equals("visa")) {
            if ((number.length() != 13 && number.length() != 16) ||
                    Integer.parseInt(number.substring(0, 1)) != 4) {
                return false;
            }

        }/* else if (s.equals("amex")) {
            if (number.length() != 15 ||
                    (Integer.parseInt(number.substring(0, 2)) != 34 &&
                            Integer.parseInt(number.substring(0, 2)) != 37)) {
                return false;
            }

        } else if (s.equals("discover")) {
            if (number.length() != 16 ||
                    Integer.parseInt(number.substring(0, 5)) != 6011) {
                return false;
            }

        } else if (s.equals("diners")) {
            if (number.length() != 14 ||
                    ((Integer.parseInt(number.substring(0, 2)) != 36 &&
                            Integer.parseInt(number.substring(0, 2)) != 38) &&
                            Integer.parseInt(number.substring(0, 3)) < 300 ||
                            Integer.parseInt(number.substring(0, 3)) > 305)) {
                return false;
            }

        }*/
        return isValidCardNumber(number);
    }

    private boolean  validateSumOnCard(){
        return true;
    }
}

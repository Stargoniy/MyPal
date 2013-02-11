package com.in6k.mypal.service;

import java.util.ArrayList;
import java.util.List;

class IncreaseBalanсe {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String nameOnCard;
    private double sum;

    public IncreaseBalanсe(String cardNumber, String expiryDate, String cvv, String nameOnCard, double sum) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.sum=sum;
    }

    public IncreaseBalanсe(){

    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public boolean moneyFromCreditCard(){
        return true;

    }


}

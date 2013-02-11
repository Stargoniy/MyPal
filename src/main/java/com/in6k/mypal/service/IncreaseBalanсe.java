package com.in6k.mypal.service;

import com.in6k.mypal.dao.TransactionDAO;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncreaseBalanсe {
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

    public boolean moneyFromCreditCard(){

        Transaction transaction = new Transaction();
        transaction.setDebit(debit);
        transaction.setCredit(credit);
        transaction.setSum(sum);

        TransactionDAO.create(transaction);
        return true;

    }

    private boolean validateCardInfo(String card, String expiry, String name, double sumOnCard, String cvvOnCard){
        this.cardNumber=card;
        this.expiryDate=expiry;
        this.nameOnCard=name;
        this.sum=sumOnCard;
        this.cvv=cvvOnCard;

        return true;
    }


}

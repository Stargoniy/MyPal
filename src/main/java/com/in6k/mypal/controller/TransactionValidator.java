package com.in6k.mypal.controller;

import com.in6k.mypal.domain.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {
    private User debit;
    private User credit;
    private double sum;

    private final static String VALID_SUM = "[-+]?(?:\\b[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+\\b)(?:[eE][-+]?[0-9]+\\b)?";

    private List validateErrors = new ArrayList();

    public TransactionValidator() {
    }

    public User getDebit() {
        return debit;
    }

    public void setDebit(User debit) {
        this.debit = debit;
    }

    public User getCredit() {
        return credit;
    }

    public void setCredit(User credit) {
        this.credit = credit;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }


    private boolean isSumValid() {
        return Double.toString(this.sum).matches(VALID_SUM);
    }

    private boolean isDebitValid () {
        return this.debit != null;
    }

    private boolean isCreditValid () {
        return this.credit != null;
    }


    public List validate() {
        String error;

        if(!isSumValid()) {
            error = "Sum is not valid.";
            validateErrors.add(error);
        }

        if(!isCreditValid()) {
            error = "Credit is not valid.";
            validateErrors.add(error);
        }

        if(!isDebitValid()) {
            error = "Debit is not valid.";
            validateErrors.add(error);
        }

        return this.validateErrors;
    }
}

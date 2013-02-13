package com.in6k.mypal.service;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {
    private User debit;
    private User credit;
    private String inputSum;
    private double sum;

    private final static String VALID_SUM = "[-+]?(?:\\b[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+\\b)(?:[eE][-+]?[0-9]+\\b)?";

    public TransactionValidator() {
    }

    public String getInputSum() {
        return inputSum;
    }

    public void setInputSum(String inputSum) {
        this.inputSum = inputSum;
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
        try {
            sum = Double.parseDouble(inputSum);
        }
        catch (NumberFormatException exception) {
            return false;
        }
        if (sum > UserDao.getBalance(credit)) {
            return false;
        }
        return true;
    }

    private boolean isDebitValid () {
        return debit != null;
    }

    private boolean isCreditValid () {
        return credit != null;
    }

    public List validate() {
        List<String> result = new ArrayList();
        if(!isSumValid()) {
            result.add("sum");
        }

        if(!isCreditValid()) {
            result.add("credit");
        }

        if(!isDebitValid()) {
            result.add("debit");
        }

        return result;
    }
}

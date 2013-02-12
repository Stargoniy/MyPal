package com.in6k.mypal.service;

import com.in6k.mypal.dao.TransactionDAO;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncreaseBalanсe {

    public static void moneyFromCreditCard(String cardNumber, String sum, int id){

        Transaction transaction = new Transaction();

        if (null != UserDao.getById(id)){
            transaction.setDebit(UserDao.getById(id));
            transaction.setCredit(UserDao.getById(id));
            transaction.setSum(Double.parseDouble(sum));
            transaction.setDesription(cardNumber);

            try {
                TransactionDAO.create(transaction);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

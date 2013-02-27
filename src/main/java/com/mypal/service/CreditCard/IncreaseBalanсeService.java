package com.mypal.service.CreditCard;

import com.mypal.dao.TransactionDao;
import com.mypal.dao.UserDao;
import com.mypal.domain.Transaction;

import java.io.IOException;

public class IncreaseBalanсeService {

    public static void moneyFromCreditCard(String cardNumber, String sum, int id, boolean fromCard){
                
        Transaction transaction = new Transaction();

        if (null != UserDao.getById(id)){
            if (fromCard) {
                transaction.setDebit(UserDao.getById(id));
                transaction.setCredit(UserDao.getById(-1));
            } else {
                transaction.setDebit(UserDao.getById(-2));
                transaction.setCredit(UserDao.getById(id));
            }
            transaction.setSum(Double.parseDouble(sum));
            transaction.setStatus(true);
            try {
                TransactionDao.create(transaction);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

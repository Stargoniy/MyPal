package com.in6k.mypal.service.CreditCard;

import com.in6k.mypal.dao.TransactionDao;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.SecurityUtil;

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

            try {
                TransactionDao.create(transaction);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /*private static User saveUserFromVreditCard(String cardNumber){

        User result = UserDao.getByEmail(cardNumber);

        if (null != result){
           return result;
        }

        User user = new User();
        user.setEmail(cardNumber);
        user.setFirstName("Credit");
        user.setLastName("Card");
        user.setSystem(true);
        user.setPassword(SecurityUtil.passwordEncoder(cardNumber + cardNumber.substring(2,7)));
        UserDao.save(user);

        return UserDao.getByEmail(user.getEmail());

    }*/

}

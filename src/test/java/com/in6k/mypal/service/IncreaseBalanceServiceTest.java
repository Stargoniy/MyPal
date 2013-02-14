/*
package com.in6k.mypal.service;

import com.in6k.mypal.dao.TransactionDao;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.service.CreditCard.IncreaseBalanсeService;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class IncreaseBalanceServiceTest {
    @Test
    void shouldCreateTransactionIfUserExist {
        User creditUser = new User();
        creditUser.setEmail("credit@gmail.com");
        creditUser.setFirstName("CreditName");
        creditUser.setLastName("CreditLastName");
        creditUser.setPassword("123456");
        creditUser.setActive(true);

        UserDao.save(creditUser);

        IncreaseBalanсeService.moneyFromCreditCard("5105105105105100", "100", creditUser.getId(), true);

        try {
            TransactionService.create(creditUser, debitUserEmail, "10");
        } catch (IOException e) {
            fail();
        }

        Transaction transaction = TransactionDao.findAllForUser(debitUser).get(0);
        assertEquals(TransactionDao.findAllForUser(creditUser).get(1).getId(), transaction);
        assertEquals(90.0, UserDao.getBalance(creditUser));
        assertEquals(10.0, UserDao.getBalance(debitUser));
    }
}
*/

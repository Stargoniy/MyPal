package com.mypal.service;

import com.mypal.dao.CommonDao;
import com.mypal.dao.TransactionDao;
import com.mypal.dao.UserDao;
import com.mypal.domain.Transaction;
import com.mypal.domain.User;
import com.mypal.service.CreditCard.IncreaseBalanсeService;
import com.mypal.util.SecurityUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TransactionServiceTest {
    @Before
    public void clearTables() {
        CommonDao.clearTable("transactions");
        CommonDao.clearTable("users");
    }

    @Test
    public void shouldCreateTransactionIfUserExistAndCreditUserHaveMoney() {
        User creditUser = new User();
        creditUser.setEmail("credit@example.com");
        creditUser.setFirstName("CreditName");
        creditUser.setLastName("CreditLastName");
        creditUser.setPassword(SecurityUtil.passwordEncoder("secret"));
        creditUser.setActive(true);

        UserDao.save(creditUser);

        IncreaseBalanсeService.moneyFromCreditCard("5105105105105100", "100", creditUser.getId(), true);

        User debitUser = new User();
        String debitUserEmail = "debit@example.com";
        debitUser.setEmail(debitUserEmail);
        debitUser.setFirstName("DebitName");
        debitUser.setLastName("DebitLastName");
        debitUser.setPassword(SecurityUtil.passwordEncoder("secret"));
        debitUser.setActive(true);
        UserDao.save(debitUser);

        try {
            TransactionService.create(creditUser, debitUserEmail, "10");
        } catch (IOException e) {
            fail();
        }

        Transaction transaction = TransactionDao.findAllForUser(debitUser).get(0);
        assertNotNull(transaction);
        assertEquals(10.0, transaction.getSum());
        assertEquals(TransactionDao.findAllForUser(creditUser).get(1).getId(), transaction.getId());
        assertEquals(90.0, UserDao.getBalance(creditUser));
        assertEquals(10.0, UserDao.getBalance(debitUser));
    }

    @Test
    public void shouldCreateTransactionIfUserNotExistButCreditUserHaveMoney() {
        User creditUser = new User();
        creditUser.setEmail("credit@example.com");
        creditUser.setFirstName("CreditName");
        creditUser.setLastName("CreditLastName");
        creditUser.setPassword(SecurityUtil.passwordEncoder("secret"));
        creditUser.setActive(true);

        UserDao.save(creditUser);

        IncreaseBalanсeService.moneyFromCreditCard("5105105105105100", "100", creditUser.getId(), true);

        String debitUserEmail = "debit@example.com";

        try {
            TransactionService.create(creditUser, debitUserEmail, "10");
        } catch (IOException e) {
            fail();
        }

        User debitUser = UserDao.getByEmail(debitUserEmail);
        Transaction transaction = TransactionDao.findAllForUser(debitUser).get(0);
        assertNotNull(transaction);
        assertEquals(10.0, transaction.getSum());
        assertEquals(TransactionDao.findAllForUser(creditUser).get(1).getId(), transaction.getId());
        assertEquals(90.0, UserDao.getBalance(creditUser));
        assertEquals(10.0, UserDao.getBalance(debitUser));
    }

    @Test
    public void shouldNotCreateTransactionIfUserDontHaveEnoughMoney() {
        User creditUser = new User();
        creditUser.setEmail("credit@example.com");
        creditUser.setFirstName("CreditName");
        creditUser.setLastName("CreditLastName");
        creditUser.setPassword(SecurityUtil.passwordEncoder("secret"));
        creditUser.setActive(true);

        UserDao.save(creditUser);

        User debitUser = new User();
        String debitUserEmail = "debit@example.com";
        debitUser.setEmail(debitUserEmail);
        debitUser.setFirstName("DebitName");
        debitUser.setLastName("DebitLastName");
        debitUser.setPassword(SecurityUtil.passwordEncoder("secret"));
        debitUser.setActive(true);
        UserDao.save(debitUser);

        try {
            TransactionService.create(creditUser, debitUserEmail, "200");
        } catch (IOException e) {
            fail();
        }

        assertEquals(0, TransactionDao.findAllForUser(creditUser).size());
    }
}

package com.in6k.mypal.service;

import com.in6k.mypal.dao.CommonDao;
import com.in6k.mypal.dao.TransactionDao;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.service.CreditCard.IncreaseBalanсeService;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class IncreaseBalanceServiceTest {
    @Test
    public void shouldGetMoneyIfUserExist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.createSQLQuery("INSERT INTO mypal_test.users (id, first_name, last_name, email, password, active, system) VALUES (-2, 'Bank', 'Output', 'ivanov@mypal.com', '234', TRUE, TRUE);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.users (id, first_name, last_name, email, password, active, system) VALUES (-1, 'Bank', 'Input', 'ibank@mypal.com', '123', TRUE, TRUE);").executeUpdate();

        session.getTransaction().commit();
        session.close();

        User creditUser = new User();
        creditUser.setEmail("credit@gmail.com");
        creditUser.setFirstName("CreditName");
        creditUser.setLastName("CreditLastName");
        creditUser.setPassword("123456");
        creditUser.setActive(true);

        UserDao.save(creditUser);

        IncreaseBalanсeService.moneyFromCreditCard("5105105105105100", "100", creditUser.getId(), true);
        IncreaseBalanсeService.moneyFromCreditCard("5105105105105100", "100", creditUser.getId(), false);

        Transaction transaction = TransactionDao.findAllForUser(creditUser).get(0);

        assertNotNull(transaction);
        assertEquals((double)0, UserDao.getBalance(creditUser));

    }
}


package com.mypal.service.creditcard;

import com.mypal.dao.TransactionDao;
import com.mypal.dao.UserDao;
import com.mypal.domain.Transaction;
import com.mypal.domain.User;
import com.mypal.service.CreditCard.IncreaseBalanсeService;
import com.mypal.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
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


package com.in6k.mypal.form;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class LoginFormTest {
    User user;
    User creditCard;

    @Before
    public void setUp() {
        user = UserDao.getByEmail("HeavyCK@ukr.net");
        creditCard = UserDao.getByEmail("email");
    }

    @Test
    public void IsUserTrue() {

        LoginForm lf = new LoginForm(user.getEmail(), "123456");
        assertTrue(lf.isUser());
    }

    @Test
    public void isNotUser() {
        LoginForm lf = new LoginForm(creditCard.getEmail(), "123456");
        assertFalse(lf.isUser());
    }




}

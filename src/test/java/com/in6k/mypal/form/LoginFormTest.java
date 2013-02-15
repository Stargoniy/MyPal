package com.in6k.mypal.form;

import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LoginFormTest {
    public String email = "HeavyCK@ukr.net";
    public String password = "123456";
    User user;
    User creditCard;

    @Before
    public void setUp() {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);

        UserDao.save(newUser);

        user = UserDao.getByEmail("HeavyCK@ukr.net");
        creditCard = UserDao.getByEmail("email");
    }

    @Test
    public void IsUserTrue() {
        LoginForm lf = new LoginForm(user.getEmail(), password);
        assertTrue(lf.isUser());
    }

    @Test
    public void isNotUser() {
        LoginForm lf = new LoginForm(creditCard.getEmail(), password);
        assertFalse(lf.isUser());
    }

}

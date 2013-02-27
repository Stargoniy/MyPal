package com.mypal.form;

import com.mypal.dao.UserDao;
import com.mypal.domain.User;
import com.mypal.util.SecurityUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LoginFormTest {
    public String password = "123456";
    User user;
    User creditCard;

    @Before
    public void setUp() {
        User newUser = new User();
        newUser.setEmail("HeavyCK@ukr.net");
        newUser.setPassword(SecurityUtil.passwordEncoder(password));

        UserDao.save(newUser);

        User systemUser = new User();
        systemUser.setSystem(true);
        systemUser.setEmail("email@mail.com");
        systemUser.setPassword(SecurityUtil.passwordEncoder("123456"));

        UserDao.save(systemUser);

        user = UserDao.getByEmail("HeavyCK@ukr.net");
        creditCard = UserDao.getByEmail("email@mail.com");
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

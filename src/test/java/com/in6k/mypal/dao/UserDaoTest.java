package com.in6k.mypal.dao;

import com.in6k.mypal.domain.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void shouldGetBalance() {
        User user = new User();
        user.setId(1);
        assertNotNull(UserDao.getBalance(user));
        assertEquals(-200.0, UserDao.getBalance(user));
    }

    @Test
    public void shouldGetZeroBalance() {
        User user = new User();
        user.setId(-1);
        assertEquals(0.0, UserDao.getBalance(user));
    }

}

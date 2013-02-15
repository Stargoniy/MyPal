package com.in6k.mypal.dao;

import com.in6k.mypal.domain.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    @Test
    public void shouldGetUserById() {
        assertEquals(User.class, UserDao.getById(1).getClass());
    }

    @Test
    public void shouldGetUserByIdIfUserExist() {
        User testedUser = new User();
        User user = new User();
        testedUser = setUserInfo(user, 1, "Vasya", "Germanov", "admin@gmail.com", "81dc9bdb52d04dc2036dbd8313ed055", true, false);
        user = UserDao.getById(1);
        testUsers(testedUser, user);
    }

    @Test
    public void shouldGetNullIfUserDontExist() {
        assertNull(UserDao.getById(-5));
    }

    @Test
    public void shouldSaveUser() {
        User testedUser = new User();
        User user = new User();
        testedUser = setUserInfo(user, 5, "Ivan", "Pavlov", "ivan@gmail.com", "81dc9bdb52d04dc2036dbd8313ed055", true, false);
        UserDao.save(testedUser);
        user =  UserDao.getById(24);
        testUsers(testedUser, user);
    }

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

    private User setUserInfo(User user, int id, String firstName, String lastName, String email, String password,
                                boolean active, boolean system) {
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setActive(active);
        user.setSystem(system);

        return user;
    }

    private void testUsers(User testedUser, User user) {
        assertEquals( testedUser.getId(), user.getId());
        assertEquals( testedUser.getFirstName(), user.getFirstName());
        assertEquals( testedUser.getLastName(), user.getLastName());
        assertEquals( testedUser.getEmail(), user.getEmail());
        assertEquals( testedUser.getPassword(), user.getPassword());
        assertEquals( testedUser.getActive(), user.getActive());
    }
}

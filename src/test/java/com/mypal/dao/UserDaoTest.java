package com.mypal.dao;

import com.mypal.domain.User;

import com.mypal.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    private Session session;

    @Before
    public void insertDataToDatabase() {
        CommonDao.clearTable("transactions");
        CommonDao.clearTable("users");

        createSession();

        insertData();

        closeSession();
    }

    @Test
    public void shouldGetUserObjectById() {
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
    public void shouldGetNullIfUserDontExistWithSpecifiedId() {
        assertNull(UserDao.getById(-5));
    }

    @Test
    public void shouldSaveUser() {
        User testedUser = new User();
        User user = new User();
        testedUser = setUserInfo(user, 5, "Ivan", "Pavlov", "ivan@gmail.com", "81dc9bdb52d04dc2036dbd8313ed055", true, false);
        UserDao.save(testedUser);
        user =  UserDao.getById(5);
        testUsers(testedUser, user);
    }

    @Test
    public void shouldGetUserObjectByEmail() {
        assertEquals(User.class, UserDao.getById(1).getClass());
    }

    @Test
    public void shouldGetUserByEmailIfUserExist() {
        User testedUser = new User();
        User user = new User();
        testedUser = setUserInfo(user, 1, "Vasya", "Germanov", "admin@gmail.com", "81dc9bdb52d04dc2036dbd8313ed055", true, false);
        user = UserDao.getById(1);
        testUsers(testedUser, user);
    }

    @Test
    public void shouldGetNullIfUserDontExistWithSpecifiedEmail() {
        assertNull(UserDao.getById(-5));
    }

    @Test
    public void shouldGetArrayOfUserObjects() {
        List<User> users = new ArrayList<User>();
        assertEquals(users.getClass(), UserDao.list().getClass());
    }

    @Test
    public void shouldGetBalance() {
        User user = new User();
        user.setId(1);
        assertNotNull(UserDao.getBalance(user));
        assertEquals(200.0, UserDao.getBalance(user));
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

    private void createSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    private void insertData() {
        session.createSQLQuery("INSERT INTO mypal_test.users (id, active, email, facebook_id, first_name, last_name, password, system) VALUES (1, true, 'admin@gmail.com', null, 'Vasya', 'Germanov', '81dc9bdb52d04dc2036dbd8313ed055', false);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.users (id, active, email, facebook_id, first_name, last_name, password, system) VALUES (2, true, 'alex@gmail.com', null, 'Alex', 'Vasnecov', '81dc9bdb52d04dc2036dbd8313ed055', false);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.users (id, active, email, facebook_id, first_name, last_name, password, system) VALUES (3, true, 'pasha@gmail.com', null, 'Pasha', 'Muhaylov', '81dc9bdb52d04dc2036dbd8313ed055', false);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.users (id, active, email, facebook_id, first_name, last_name, password, system) VALUES (4, true, 'petro@gmail.com', null, 'Petro', 'Semonenko', '81dc9bdb52d04dc2036dbd8313ed055', false);").executeUpdate();


        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (1, true, 100, 2, 1);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (2, true, 50, 3, 1);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (3, true, 50, 4, 1);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (4, true, 30, 4, 2);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (5, true, 30, 3, 2);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (6, true, 40, 2, 3);").executeUpdate();
        session.createSQLQuery("INSERT INTO mypal_test.transactions (id, status, sum, credit_id, debit_id) VALUES (7, false, 40, 4, 3);").executeUpdate();
    }

    private void closeSession() {
        session.getTransaction().commit();
        session.close();
    }
}

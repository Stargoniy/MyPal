package com.in6k.mypal;

import com.in6k.mypal.dao.TransactionDAO;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        User user1 = new User();
        user1.setEmail("email@mail11.ru");
        user1.setFirstName("name3");
        user1.setLastName("lastname3");
        user1.setPassword("pwd11");

        User user2 = new User();
        user2.setEmail("email@gmail11.com");
        user2.setFirstName("name4");
        user2.setLastName("lastname4");
        user2.setPassword("pwd222");

        UserDao.save(user1);
        UserDao.save(user2);

        Transaction tr = new Transaction();
        tr.setSum(120.0);
        tr.setCredit(user1);
        tr.setDebit(user2);

        TransactionDAO.create(tr);
    }
}

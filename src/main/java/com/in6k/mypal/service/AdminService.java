package com.in6k.mypal.service;

import com.in6k.mypal.dao.TransactionDao;
import com.in6k.mypal.dao.UserDao;
import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class AdminService {

    public  void banUser(int id) {
        User user = UserDao.getById(id);
        if (user.getId() > 0) {
            user.setActive(false);
            UserDao.update(user);
        }
    }

    public void unBanUser(int id) {
        User user = UserDao.getById(id);
        if (user.getId() > 0) {
            user.setActive(true);
            UserDao.update(user);
        }
    }


    public List transactionsForUserById(int id) {
        return TransactionDao.findAllForUser(UserDao.getById(id));
    }

    public List showAllTransactions() throws IOException, SQLException {
        return TransactionDao.list();
    }

    public void cancelTransaction(int id) throws SQLException {
        Transaction transaction = TransactionDao.getById(id);
        if (transaction.getId() > 0) {
        transaction.setStatus(false);
        TransactionDao.update(transaction);
        }
    }

    public void restoreTransaction(int id) throws SQLException {
        Transaction transaction = TransactionDao.getById(id);
        if (transaction.getId() > 0) {
            transaction.setStatus(true);
            TransactionDao.update(transaction);
        }
    }
}

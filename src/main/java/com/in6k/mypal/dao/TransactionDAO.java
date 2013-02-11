package com.in6k.mypal.dao;

import com.in6k.mypal.domain.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class TransactionDAO {

    @Autowired
    private static SessionFactory sessionFactory;

    public static void create(Transaction transaction) {
        sessionFactory.getCurrentSession().save(transaction);
    }

    public static List<Transaction> listTransaction() {

        return sessionFactory.getCurrentSession().createQuery("from Transaction")
                .list();
    }

    public static void delete(Integer id) throws SQLException {
        Transaction transaction = (Transaction) sessionFactory.getCurrentSession().load(
                Transaction.class, id);
        if (null != transaction) {
            sessionFactory.getCurrentSession().delete(transaction);
        }

    }

}

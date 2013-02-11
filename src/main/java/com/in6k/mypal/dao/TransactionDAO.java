package com.in6k.mypal.dao;

import com.in6k.mypal.domain.Transaction;
import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public static List<Transaction> findAllForUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery("SELECT * FROM transactions WHERE debit=? OR credit=?;");
        String userEmail = user.getEmail();
        query.setString(0, userEmail);
        query.setString(1, userEmail);
        List<Transaction> result = query.list();

        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
        return result;
    }

    public static void create(Transaction transaction) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static List<Transaction> list() throws IOException, SQLException {
        Session session = null;
        List<Transaction> list = new ArrayList<Transaction>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Transaction.class).list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return list;
    }

    public static void delete(Integer id) throws SQLException {
        Session session = null;
        Transaction transaction = getById(id);

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(transaction);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Delete Error", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Transaction getById(Integer id) throws SQLException {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = (Transaction) session.get(Transaction.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return transaction;
    }

}

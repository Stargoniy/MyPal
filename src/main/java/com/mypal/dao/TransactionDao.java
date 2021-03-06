package com.mypal.dao;

import com.mypal.domain.Transaction;
import com.mypal.domain.User;
import com.mypal.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    public static List<Transaction> findAllForUser(User user) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Query query = session.createSQLQuery("SELECT * FROM transactions WHERE debit_id = ? OR credit_id = ?;");
//        int userId = user.getId();
//        query.setInteger(0, userId);
//        query.setInteger(1, userId);
//        List<Transaction> result = query.list();
//
//        session.getTransaction().commit();
//
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Transaction> result = session.createCriteria(Transaction.class).add(Expression.or(Expression.like("debit", user), Expression.like("credit", user))).list();
        session.getTransaction().commit();
        session.close();
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

    public static void update(Transaction transaction) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(transaction);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}

package com.in6k.mypal.dao;

import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static User getById(Integer id) {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public static User getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List userList = session.createCriteria(User.class).add(Expression.like("email", email)).list();
        User result = null;
        if (userList != null && userList.size() > 0) {
            result = (User) userList.get(0);
        }
        session.getTransaction().commit();

        return result;
    }

    public static double getBalance(User user) {
        return 0;
    }

    public static ArrayList<User> list() {
        ArrayList<User> result = new ArrayList<User>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        result.addAll(session.createCriteria(User.class).list());

        tx.commit();
        session.close();

        return result;
    }
}

